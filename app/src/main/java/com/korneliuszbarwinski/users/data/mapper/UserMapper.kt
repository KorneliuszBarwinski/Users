package com.korneliuszbarwinski.users.data.mapper

import com.korneliuszbarwinski.users.data.local.model.UserCached
import com.korneliuszbarwinski.users.data.remote.model.UserGitHubResponse
import com.korneliuszbarwinski.users.domain.model.User

fun UserCached.toDomainModel() = User(
    name = name,
    photoUrl = avatarUrl,
    source = source
)

fun UserGitHubResponse.toEntityModel() = UserCached(
    id = id,
    name = login,
    avatarUrl = avatarUrl,
    source = "github.com"
)