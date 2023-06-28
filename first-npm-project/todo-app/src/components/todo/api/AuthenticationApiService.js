import { apiClient } from "./ApiClient"

export async function authenticateApiService(username, password) {
    return apiClient.post('/authenticate', {username, password})
}
