import { createContext, useState } from 'react'
import { authenticate } from '../api/UserApiService'


export const AuthContext = createContext()

// in TodoApp.jsx <AuthContextProvider>{ children }</AuthContextProvider>
// children is Header, Routes, Footer
export default function AuthContextProvider({ children }) {

    // 1. const authContext = useContext(AuthContext)
    // 2-1. authContext.isAuthenticated, authContext.username, authContext.token
    // 2-2. authContext.login(username, password), authContext.logout()
    const [isAuthenticated, setAuthenticated] = useState(false)
    const [username, setUsername] = useState(null)
    const [token, setToken] = useState(null)

    async function login(username, password) {
        function setUseStateWhenLogin(username, token) {
            setAuthenticated(true)
            setUsername(username)
            setToken(token)
        }
        function setUseStateWhenLogout() {
            logout()
        }

        // username and password are encoded in base-64 as a token
        const baToken = 'Basic ' + window.btoa(username + ':' + password)

        try {
            const response =  await authenticate(token)
            if (response.status !== 200) {
                setUseStateWhenLogout()
                console.log('AuthContext.js: login fail...')
                return false
            }
            setUseStateWhenLogin(username, baToken)
            console.log('AuthContext.js: login success...')
            return true

        } catch (error) {
            setUseStateWhenLogout()
            return false
        }


    }
    
    function logout() {
        setAuthenticated(false)
        setUsername(null)
        setToken(null)
    }



    return (
        <AuthContext.Provider value={ {isAuthenticated, username, token, login, logout} }>
            {children}
        </AuthContext.Provider>
    )
}
