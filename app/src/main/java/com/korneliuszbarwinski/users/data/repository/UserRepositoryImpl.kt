package com.korneliuszbarwinski.users.data.repository

import com.korneliuszbarwinski.users.data.local.dao.UserDao
import com.korneliuszbarwinski.users.data.mapper.toDomainModel
import com.korneliuszbarwinski.users.data.mapper.toEntityModel
import com.korneliuszbarwinski.users.data.remote.api.UserGitHubApi
import com.korneliuszbarwinski.users.domain.model.User
import com.korneliuszbarwinski.users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

class UserRepositoryImpl @Inject constructor(
    private val userGitHubApi: UserGitHubApi,
    private val userDao: UserDao
): UserRepository {
    override suspend fun getUsers(): Flow<List<User>> {
        return userDao
            .getUsers()
            .map { usersCached ->
                usersCached.map { it.toDomainModel() }
            }.onEach { users ->
                if (users.isEmpty()){
                    refreshUsers()
                }
            }
    }

    override suspend fun refreshUsers() {
        userGitHubApi
            .getUsers()
            .map {
                it.toEntityModel()
            }
            .also{
                userDao.saveUsers(it)
            }
    }
}