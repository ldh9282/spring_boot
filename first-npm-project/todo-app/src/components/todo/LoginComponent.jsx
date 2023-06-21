import { useContext, useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { AuthContext } from './security/AuthContext'

export default function LoginComponent() {
    const [username, setUsername] = useState('in28minutes');
    const [password, setPassword] = useState('dummy');
    
    const [showErrorMessage, setShowErrorMessage] = useState(false);

    const navigate = useNavigate();
    const authContext = useContext(AuthContext)
    function handleUsernameChange(event) {
        setUsername(event.target.value);
    }

    function handlePasswordChange(event) {
        setPassword(event.target.value);
    }

    async function handleSubmit() {
        if (!await authContext.login(username, password)) {
            debugger
            console.log('LoginComponent.jsx: login fail...')
            setShowErrorMessage(true)
            return
        }
        console.log('LoginComponent.jsx: login success...')
        navigate(`/welcome/${username}`)
    }


    return (
        <div className='Login'>
            <h1>Time to Login!</h1>
            {showErrorMessage 
                && <div className='errorMessage' >Autenticated Failed. Please check your credentials.</div>}

            <div className='LoginForm'>
                <div>
                    <label>User Name:</label>
                    <input type='text' name='username' value={username} onChange={handleUsernameChange} placeholder='in28minutes' />
                </div>
                <div>
                    <label>Password:</label>
                    <input type='password' name='password' value={password} onChange={handlePasswordChange} />
                </div>
                <div>
                    <button type='button' name='login' onClick={handleSubmit}>login</button>
                </div>
            </div>
        </div>
    )
}