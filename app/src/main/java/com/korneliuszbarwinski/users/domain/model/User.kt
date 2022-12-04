package com.korneliuszbarwinski.users.domain.model

import java.io.Serializable

data class User(
    val name: String,
    val photoUrl: String,
    val source: String
): Serializable
