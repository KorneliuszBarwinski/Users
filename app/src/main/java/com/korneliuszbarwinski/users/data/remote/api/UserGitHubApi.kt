package com.korneliuszbarwinski.users.data.remote.api

import com.korneliuszbarwinski.users.data.remote.model.UserGitHubResponse
import retrofit2.http.GET

interface UserGitHubApi {
    @GET("users")
    suspend fun getUsers(): List<UserGitHubResponse>
}