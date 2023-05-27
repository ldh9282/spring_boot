import { useNavigate, useParams } from "react-router-dom"
import { retrieveToDoByUsernameAndId, updateToDoByUsernameAndId } from "./api/ToDoApiService"
import { useAuth } from "./security/AuthContext"
import { useEffect, useState } from "react"
import { ErrorMessage, Field, Form, Formik } from "formik"
export default function TodoComponent() {

    const authContext = useAuth()
    const username = authContext.username
    
    // TodoApp.jsx 에서 Route path='/todo/:todo_id' 에서 todo_id 와 일치해야함
    const {todo_id} = useParams()
    const [description, setDescription] = useState('')
    const [targetDate, setTargetDate] = useState('')
    
    // 초기로딩 시 retrieveToDo, 그리고 todo_id 가 변경 시 retrieveToDo 을 모두 하는 useEffect
    // 제이쿼리로 치면 $(document).ready 에서 하고 $('#todo_id') 가 change 할때마다 하는 것
    useEffect(retrieveToDo, [todo_id])
    
    const navigate = useNavigate()

    function retrieveToDo() {
        retrieveToDoByUsernameAndId(username, todo_id)
            .then(response => {
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate.substring(0, 10))
            })
            .catch(error => console.log('error', error))
    }

    function onSubmit(props) {
            
        const todo = props

        todo && (function() {
            todo.id = todo_id   
            todo.username = username
            todo.done = false
        })()

        console.log(todo)
        
        updateToDoByUsernameAndId(username, todo_id, todo)
            .then(function(response) {
                console.log(response)
                setDescription(response.data.description)
                setTargetDate(response.data.targetDate.substring(0, 10))
                navigate('/todos')
            })
            .catch(function(error) {
                console.log(error)
            })
    }

    function validate(props) {
        const errors = {}

        props.description.length === 0 && (errors.description = 'invalid description')
        props.targetDate.length !== 10 && (errors.targetDate = 'invalid targetDate')

        JSON.stringify(errors) === '{}' ? console.log('valid props') : console.log(errors)
        return errors
        
    }
    return (
        <div className="TodoComponent">
            <h1>Enter To-Do details</h1>
            <div className="mt-5">
                
                <Formik initialValues={ {description, targetDate} }
                        enableReinitialize={true}
                        onSubmit={onSubmit}
                        validate={validate}
                        /* save 버튼 클릭시만 validate 하도록
                         change, blur(focus out) 일때는 동작안함 */
                        validateOnChange={false} 
                        validateOnBlur={false}> 
                    {
                        (props) => {
                            return (
                                <Form className="w-50 mx-auto">
                                    <ErrorMessage 
                                        name="description"
                                        component="div"
                                        className="alert alert-warning"/>
                                        
                                    <ErrorMessage 
                                        name="targetDate"
                                        component="div"
                                        className="alert alert-warning"/>


                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field type="text" className="form-control" name="description"></Field>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Target Date</label>
                                        <Field type="date" className="form-control" name="targetDate"></Field>
                                    </fieldset>
                                    <div>
                                        <button type="submit" className="btn btn-success mt-5">Save</button>
                                    </div>
                                </Form>
                            )
                        }
                    }
                </Formik>
            </div>
        </div>
    )
}