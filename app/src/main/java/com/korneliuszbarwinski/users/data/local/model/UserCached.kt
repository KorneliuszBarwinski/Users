package com.korneliuszbarwinski.users.data.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class UserCached (
        @PrimaryKey
        @ColumnInfo(name = "id")
        val id: Int,

        @ColumnInfo(name = "name")
        val name: String,

        @ColumnInfo(name = "avatar_url")
        val avatarUrl: String,

        @ColumnInfo(name = "source")
        val source: String
        )
