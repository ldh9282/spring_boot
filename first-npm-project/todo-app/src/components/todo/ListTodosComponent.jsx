import { useState } from "react"
import { deleteToDoByUsernameAndId, retrieveToDoListByUsername } from "./api/ToDoApiService"
import { useAuth } from "./security/AuthContext"
import { useNavigate } from "react-router-dom"

export default function ListTodosComponent() {

    const authContext = useAuth()

    const username = authContext.username
    
    const navigate = useNavigate()
    
    function setTheToDos(response) {
        setToDos(response.data)
    }

    function updateToDo(username, todo_id) {
        alert('update: ' + username + ': ' + todo_id)
        navigate('/todo/' + todo_id)
    }

    function deleteToDo(username, todo_id) {
        deleteToDoByUsernameAndId(username, todo_id)
            .then(
                () => {
                    alert('delete: ' + username + ': ' + todo_id)
                }
            )
    }

    const [toDos, setToDos] = useState([])

    retrieveToDoListByUsername('user11')
        .then(setTheToDos)

    return (
        <div className='container'>
            <h1>Things You Want To Do!</h1>
            <div className="mt-5">
                <table className='table'>
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Username</th>
                            <th>Description</th>
                            <th>Is Done?</th>
                            <th>Target Date</th>
                            <th>And Time</th>
                            <th></th>
                            <th></th>
                        </tr>
                    </thead>
                    <tbody>
                    {
                        toDos.map((toDo, id) => (
                            <tr key={id + 1}>
                                <td>{id + 1}</td>
                                <td>{toDo.username}</td>
                                <td>{toDo.description}</td>
                                <td>{toDo.done ? 'Done' : 'Not Yet'}</td>
                                <td>{toDo.targetDate.substring(0,10)}</td>
                                <td>{toDo.targetDate.substring(11)}</td>
                                <td><button className="btn btn-success" type="button" onClick={() => updateToDo(toDo.username, toDo.todo_id)}>Update</button></td>
                                <td><button className="btn btn-danger" type="button" onClick={() => deleteToDo(toDo.username, toDo.todo_id)}>Delete</button></td>
                            </tr>
                        ))
                    }                        
                    </tbody>
                </table>
            </div>
        </div>
    )
}

