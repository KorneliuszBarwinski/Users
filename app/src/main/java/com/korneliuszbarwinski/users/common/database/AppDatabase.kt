package com.korneliuszbarwinski.users.common.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.korneliuszbarwinski.users.data.local.dao.UserDao
import com.korneliuszbarwinski.users.data.local.model.UserCached

private const val DATABASE_VERSION = 1

@Database(
    entities = [UserCached::class],
    version = DATABASE_VERSION,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
}