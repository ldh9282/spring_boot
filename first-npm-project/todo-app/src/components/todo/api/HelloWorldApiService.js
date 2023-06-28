import { apiClient } from "./ApiClient"

export function retrieveHelloWorldApiService() {
    return apiClient.get("/hello-world")
}