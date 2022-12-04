package com.korneliuszbarwinski.users.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.korneliuszbarwinski.users.data.local.model.UserCached
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {

    @Query("SELECT * FROM UserCached")
    fun getUsers(): Flow<List<UserCached>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveUsers(users: List<UserCached>)
}