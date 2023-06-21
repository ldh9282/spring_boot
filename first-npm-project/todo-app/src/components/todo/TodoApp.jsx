import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import LoginComponent from './LoginComponent'
import WelcomeComponent from './WelcomeComponent'
import LogoutComponent from './LogoutComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponent from './ListTodosComponent'
import FooterComponent from './FooterComponent'
import ErrorComponent from './ErrorComponent'
import TodoComponent from './TodoComponent'
import AuthContextProvider, { AuthContext } from "./security/AuthContext"

import './TodoApp.css'
import { useContext } from 'react'

function AutenticatedRoute({children}) {
    const authContext = useContext(AuthContext)
    if (authContext.isAuthenticated) {
        return children
    }
    return <Navigate to="/login" />
}

export default function TodoApp() {
    return (
        <div className="TodoApp">

                <BrowserRouter>
                    <AuthContextProvider>

                        <HeaderComponent />

                        <Routes>
                            <Route path='/' element={<LoginComponent />} />
                            <Route path='/login' element={<LoginComponent />} />
                            <Route path='/logout' element={<LogoutComponent />} />
                            <Route path='/welcome/:username' element={
                                <AutenticatedRoute>
                                    <WelcomeComponent />
                                </AutenticatedRoute>
                                } />
                            <Route path='/todos' element={
                                <AutenticatedRoute>
                                    <ListTodosComponent />    
                                </AutenticatedRoute>
                            } />
                            <Route path='/todo/:todo_id' element={
                                <AutenticatedRoute>
                                    <TodoComponent />    
                                </AutenticatedRoute>
                            } />

                            <Route path='/*' element={<ErrorComponent />} />
                        </Routes>
                        
                        <FooterComponent />
                    </AuthContextProvider>

                </BrowserRouter>


        </div>
    )
}




