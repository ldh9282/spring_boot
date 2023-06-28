import { createContext, useState } from 'react'
import { apiClient } from '../api/ApiClient'
import { authenticateApiService } from '../api/AuthenticationApiService'


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


        try {
            const response =  await authenticateApiService(username, password)

            if (response.status === 200) {
                const jwtToken = 'Bearer ' + response.data.token
                setUseStateWhenLogin(username, jwtToken)
                console.log('AuthContext.js: login success...')
    
                apiClient.interceptors.request.use(function(config) {
                    console.log('AuthContext.js: intercepting and adding a token')
                    config.headers.Authorization = jwtToken
                    return config
                })
                return true
            } else {
                setUseStateWhenLogout()
                console.log('AuthContext.js: login fail...')
                return false
            }


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
