import { Link } from "react-router-dom"
import { retrieveHelloWorldApiService } from "./api/HelloWorldApiService"

export default function WelcomeComponent() {

    function callHelloWorlApiService() {
        // axios: for http request with promise
        // syntax: axios.method("url")
        // method: get, post, delete, put, patch
        retrieveHelloWorldApiService()
            .then(function(response) {
                alert(response.data)
            })
            .catch(function(error) {
                alert(error)
            })

    }




    return (
        <>
            <div className="WelcomeComponent">
                <h1>Welcome username</h1>
                <div>
                    Manage Your todos - <Link to="/todos">Go here</Link>
                </div>
            </div>
            <div>
                <button className="btn btn-success mt-5" onClick={callHelloWorlApiService}>Call Hello World Api Service</button>
            </div>
            
            
        </>
    )
}
