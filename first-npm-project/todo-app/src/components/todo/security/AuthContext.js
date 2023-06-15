import { createContext, useContext, useState } from 'react'
import { authenticate } from '../api/UserApiService'

// 1. Create  a context
export const AuthContext = createContext()

export const useAuth = () => useContext(AuthContext)

// 2. Share the created context with other components
export default function AuthProvider({ children }) {

    // 3. Put some state in the context
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(false)

    function login(username, password) {
        // username and password are encoded in base-64 as a token
        const token = 'Basic ' + window.btoa(username + ':' + password)
        authenticate(token)
            .then(function(response) {
                console.log(response)
            })
            .catch(function(error) {
                console.log(error);
            })
        setAuthenticated(false)

        // if (username === 'in28minutes' && password === 'dummy') {
        //     setAuthenticated(true)
        //     setUsername(username)
        //     return true
        // } else {
        //     setAuthenticated(false)
        //     setUsername(null)   
        //     return false
        // }
    }

    function logout() {
        setAuthenticated(false)
        setUsername(null)
    }

    return (
        <AuthContext.Provider value={ {isAuthenticated, username, login, logout} }>
            {children}
        </AuthContext.Provider>
    )
}
