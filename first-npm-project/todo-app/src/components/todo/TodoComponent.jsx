import { useNavigate, useParams } from "react-router-dom"
import { retrieveToDoByUsernameAndId, updateToDoByUsernameAndId, createToDo } from "./api/ToDoApiService"
import { useContext, useEffect, useState } from "react"
import { ErrorMessage, Field, Form, Formik } from "formik"
import { AuthContext } from "./security/AuthContext"
export default function TodoComponent() {

    const authContext = useContext(AuthContext)
    const username = authContext.username
    
    // TodoApp.jsx 에서 Route path='/todo/:todo_id' 에서 todo_id 와 일치해야함
    const {todo_id} = useParams()
    const [description, setDescription] = useState('')
    const [target_date, setTarget_date] = useState('')
    
    // 초기로딩 시 retrieveToDo, 그리고 todo_id 가 변경 시 retrieveToDo 을 모두 하는 useEffect
    // 제이쿼리로 치면 $(document).ready 에서 하고 $('#todo_id') 가 change 할때마다 하는 것
    useEffect(retrieveToDo, [todo_id])
    
    const navigate = useNavigate()

    function retrieveToDo() {

        if (todo_id !== 'new') {
            
            retrieveToDoByUsernameAndId(username, todo_id)
                .then(response => {
                    setDescription(response.data.description)
                    setTarget_date(response.data.target_date.substring(0, 10))
                })
                .catch(error => console.log('error', error))
        } else {
            console.log('Enter NEW To-Do Details!')
        }
        
    }

    function onSubmit(props) {
            
        const todo = {
            todo_id: todo_id,
            username: username,
            done: false,
            description: props.description,
            target_date: props.target_date,
        }


        if (todo_id !== 'new') {
            updateToDoByUsernameAndId(username, todo_id, todo)
                .then(function(response) {
                    console.log('TodoComponent.jsx: Update Todo')
                    setDescription(response.data.description)
                    setTarget_date(response.data.target_date.substring(0, 10))
                    navigate('/todos')
                })
                .catch(function(error) {
                    console.log(error)
                })
        } else {
            todo.todo_id = -1
            createToDo(username, todo)
                .then(function(response) {
                    console.log(response)
                    setDescription(response.data.description)
                    setTarget_date(response.data.target_date.substring(0, 10))
                    navigate('/todos')
                })
                .catch(function(error) {
                    console.log(error)
                })
        }

    }

    function validate(props) {
        const errors = {}
        if (props.description.length === 0) {
            errors.description = 'Invalid Description: you typed zero length...'
            return errors
        }
        if (!props.target_date) {
            errors.description = 'Invalid Target Date: you may not type target date...'
            return errors
        }
       
        
    }
    return (
        <div className="TodoComponent">
            {
                todo_id === 'new' ? (
                    <h1>Enter NEW To-Do details</h1>
                    ) : (
                    <h1>Enter To-Do details</h1>
                )
            }

            
            <div className="mt-5">
                
                <Formik initialValues={ {description, target_date} }
                        enableReinitialize={true}
                        onSubmit={onSubmit}
                        validate={validate}
                        validateOnChange={false} 
                        validateOnBlur={false}> 
                    {
                        () => {
                            return (
                                <Form className="w-50 mx-auto">
                                    <ErrorMessage 
                                        name="description"
                                        component="div"
                                        className="alert alert-warning"/>
                                        
                                    <ErrorMessage 
                                        name="target_date"
                                        component="div"
                                        className="alert alert-warning"/>


                                    <fieldset className="form-group">
                                        <label>Description</label>
                                        <Field type="text" className="form-control" name="description"></Field>
                                    </fieldset>
                                    <fieldset className="form-group">
                                        <label>Target Date</label>
                                        <Field type="date" className="form-control" name="target_date"></Field>
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