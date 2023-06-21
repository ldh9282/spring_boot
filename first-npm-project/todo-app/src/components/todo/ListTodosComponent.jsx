import { useContext, useState } from "react"
import { deleteToDoByUsernameAndId, retrieveToDoListByUsername } from "./api/ToDoApiService"
import { useNavigate } from "react-router-dom"
import AuthContextProvider, { AuthContext } from "./security/AuthContext"

export default function ListTodosComponent() {

    const authContext = useContext(AuthContext)
    const username = authContext.username
    
    const navigate = useNavigate()
    
    function setTheToDos(response) {
        setToDos(response.data)
    }

    function updateToDo(username, todo_id) {
        navigate('/todo/' + todo_id)
    }

    function deleteToDo(username, todo_id) {
        deleteToDoByUsernameAndId(username, todo_id)
            .then(
                () => {
                    console.log('Delete To-Do >>> ' + username + ': ' + todo_id)
                }
            )
    }

    function addTodo() {
        navigate('/todo/new')
    }

    const [toDos, setToDos] = useState([])

    retrieveToDoListByUsername(username)
        .then(setTheToDos)

    return (
        <div className='container'>
            <h1>See What You ({username}) Want To-Do!</h1>
            <div className="mt-5">
                <table className='table'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>And Time (Optional Test)</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        toDos.map((toDo, id) => {
                            return (

                            <tr key={id + 1}>
                                <td>{id + 1}</td>
                                <td>{toDo.username}</td>
                                <td>{toDo.description}</td>
                                <td>{toDo.done ? 'Done' : 'Not Yet'}</td>
                                <td>{toDo.target_date.substring(0, 10)}</td>
                                <td>{toDo.target_date.substring(11, 19)}</td>
                                <td><button className="btn btn-success" type="button" onClick={() => updateToDo(toDo.username, toDo.todo_id)}>Update</button></td>
                                <td><button className="btn btn-danger" type="button" onClick={() => deleteToDo(toDo.username, toDo.todo_id)}>Delete</button></td>
                            </tr>
                            )   
                        })
                    }                        
                    </tbody>
                </table>
            </div>
            <div className="btn btn-success m-5" type="button" onClick={addTodo}>Add New Todo</div>
        </div>
    )
}

