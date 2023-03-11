import { BrowserRouter, Navigate, Route, Routes } from 'react-router-dom'
import LoginComponent from './LoginComponent'
import WelcomeComponent from './WelcomeComponent'
import LogoutComponent from './LogoutComponent'
import HeaderComponent from './HeaderComponent'
import ListTodosComponent from './ListTodosComponent'
import FooterComponent from './FooterComponent'
import ErrorComponent from './ErrorComponent'
import AuthProvider, { useAuth } from "./security/AuthContext"

import './TodoApp.css'

function AutenticatedRoute({children}) {
    const authContext = useAuth()

    if (authContext.isAuthenticated) {
        return children
    }
    return <Navigate to="/login" />
}

export default function TodoApp() {
    return (
        <div className="TodoApp">
            <AuthProvider>

                <BrowserRouter>

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

                        <Route path='/*' element={<ErrorComponent />} />
                    </Routes>
                    
                    <FooterComponent />

                </BrowserRouter>

            </AuthProvider>

        </div>
    )
}




