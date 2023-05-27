import { Link, useParams } from "react-router-dom";
import { useState } from "react"
import { retrieveHelloWorld } from "./api/HelloWorldApiService"
import { retrieveUser, retrieveUserByUsername } from "./api/UserApiService"

export default function WelcomeComponent() {
    const {username} = useParams();
    const [message, setMessage] = useState(null)
    const [user, setUser] = useState(null)
    function callHelloWorlRestApi() {
        alert("hello world!")
    
        // axios: for http request with promise
        // syntax: axios.method("url")
        // method: get, post, delete, put, patch
        retrieveHelloWorld()
            .then(successfulResponse)
            .catch(errorResponse)
            .finally(() => {console.log(">>> hello api: finish")})

    }

    function callUserRestApi() {
        retrieveUser()
            .then(successfulResponseForUserRestApi)
            .catch(errorResponse)
            .finally(() => {console.log(">>> user api: finish")})
    }

    function successfulResponseForUserRestApi(response) {
        const user = response.data
        console.log('user:', user)
        setUser(user)
    }
    
    function successfulResponse(response) {
        setMessage(response.data)
    }
    
    function errorResponse(error) {
        console.log(error)
    }

    function callUserByUsername() {
        const username = document.querySelector('#username').value;
        retrieveUserByUsername(username)
            .then(successfulResponseForUserRestApi)
            .catch(errorResponse)
            .finally(() => {console.log(">>> user api: finish")})
    }

    return (
        <>
            <div className="WelcomeComponent">
                <h1>Welcome {username}</h1>
                <div>
                    Manage Your todos - <Link to="/todos">Go here</Link>
                </div>
            </div>
            <div>
                <button className="btn btn-success mt-5" onClick={callHelloWorlRestApi}>Call Hello World Rest API</button>
            </div>
            {
                message
                    &&
                <div className="mt-5" style={{color: 'blue'}}>{message}</div>
            }
            
            <div>
                <button className="btn btn-success mt-5" onClick={callUserRestApi}>Call User Rest API</button>
            </div>
            {
                user 
                    &&
                <div className="mt-5" style={{color: 'blue'}}>username: {user.username}<br/><br/>password: {user.password}</div>
            }
            
            <div className="col-sm-6 mx-auto">
                <label htmlFor="username">Username</label>
                <input className="form-control" type="text" name="username" id="username" />
                <button className="btn btn-success m-5" onClick={callUserByUsername}>Call User By username</button>
            </div>
        </>
    )
}
