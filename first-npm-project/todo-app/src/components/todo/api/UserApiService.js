import axios from "axios"

export function retrieveUser() {
    return axios.get("http://localhost:8080/user")
}

export function retrieveUserByUsername(username) {
    return axios.get("http://localhost:8080/user/username/" + username)
}

export function authenticate(token) {
    return axios.get("http://localhost:8080/authenticate", {
        headers: {
            Authorization: token
        }
    })
}