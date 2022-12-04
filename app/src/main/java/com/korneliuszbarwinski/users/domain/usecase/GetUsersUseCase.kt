package com.korneliuszbarwinski.users.domain.usecase

import com.korneliuszbarwinski.users.domain.model.User
import com.korneliuszbarwinski.users.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetUsersUseCase @Inject constructor(
    private val repository: UserRepository
){
    suspend operator fun invoke(): Flow<List<User>> = repository.getUsers()
}