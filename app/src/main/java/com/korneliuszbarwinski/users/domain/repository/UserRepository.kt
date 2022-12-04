package com.korneliuszbarwinski.users.domain.repository

import com.korneliuszbarwinski.users.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(): Flow<List<User>>

    suspend fun refreshUsers()
}