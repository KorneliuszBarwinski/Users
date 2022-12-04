package com.korneliuszbarwinski.users.data.di

import com.korneliuszbarwinski.users.data.remote.api.UserGitHubApi
import com.korneliuszbarwinski.users.data.repository.UserRepositoryImpl
import com.korneliuszbarwinski.users.domain.repository.UserRepository
import com.korneliuszbarwinski.users.domain.usecase.GetUsersUseCase
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton

@Module(includes = [UserModule.BindsModule::class])
@InstallIn(SingletonComponent::class)
object UserModule {
    @Provides
    @Singleton
    fun provideUserApi(
        retrofit: Retrofit
    ): UserGitHubApi {
        return retrofit.create(UserGitHubApi::class.java)
    }

    fun provideGetUsersUseCase(
        userRepository: UserRepository
    ): GetUsersUseCase {
        return GetUsersUseCase(userRepository)
    }

    @Module
    @InstallIn(SingletonComponent::class)
    interface BindsModule {
        @Binds
        @Singleton
        fun bindRocketRepository(impl: UserRepositoryImpl): UserRepository
    }
}