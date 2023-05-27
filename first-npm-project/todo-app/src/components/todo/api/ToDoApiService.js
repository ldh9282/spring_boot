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
    todo.targetDate && (todo.targetDate = new Date(todo.targetDate).toISOString().substring(0, 19))
    return apiClient.put('/users/' + username + '/todos/' + todo_id, todo)
}