package com.composetoutiral.db

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import com.composetoutiral.utils.LoginConstants

@Dao
interface LoginDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveLogin(loginEntity: LoginEntity)

    @Update
    suspend fun updateLogin(loginEntity: LoginEntity)

    @Query("SELECT * FROM ${LoginConstants.LOGIN_TABLE} WHERE userId like :id")
    suspend fun getLoggedUser(id: Int): LoginEntity

    @Query("SELECT * FROM ${LoginConstants.LOGIN_TABLE} ORDER BY userId DESC")
    fun getAllLoggedUser(): MutableList<LoginEntity>

    @Query("SELECT EXISTS(SELECT * FROM ${LoginConstants.LOGIN_TABLE} ORDER BY userId DESC)")
    fun isRecordExistsUserId(): Boolean
}
