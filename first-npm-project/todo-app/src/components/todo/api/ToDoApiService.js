import axios from "axios"

const apiClient = axios.create(
    {
        baseURL: 'http://localhost:8080'
    }
)

export function retrieveToDoListByUsername(username) {
    return apiClient.get('/users/' + username + '/todos')
}

export function retrieveToDoByUsernameAndId(username, todo_id) {
    return apiClient.get('/users/' + username + '/todos/' + todo_id)
}
export function deleteToDoByUsernameAndId(username, todo_id) {
    return apiClient.delete('/users/' + username + '/todos/' + todo_id)
}

export function updateToDoByUsernameAndId(username, todo_id, todo) {
    todo.target_date && (todo.target_date = new Date(todo.target_date).toISOString().substring(0, 19) + "+09:00[GMT+09:00]")
    return apiClient.put('/users/' + username + '/todos/' + todo_id, todo)
}

export function createToDo(username, todo) {
    todo.target_date && (todo.target_date = new Date(todo.target_date).toISOString().substring(0, 19) + "+09:00[GMT+09:00]")
    return apiClient.post('/users/' + username + '/todos/' + 'new', todo)
}
