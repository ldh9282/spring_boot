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