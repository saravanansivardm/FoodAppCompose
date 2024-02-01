package com.composetoutiral.repository

import com.composetoutiral.db.LoginDao
import com.composetoutiral.db.LoginEntity
import javax.inject.Inject

class LoginRepository @Inject constructor(
    private val dao: LoginDao
) {
    suspend fun saveLogin(loginEntity: LoginEntity) = dao.saveLogin(loginEntity)
    suspend fun updateLogin(loginEntity: LoginEntity) = dao.updateLogin(loginEntity)
    suspend fun getLoggedUser(id: Int) = dao.getLoggedUser(id)
//    fun isDataExist() = dao.isDataExist()
    fun isRecordExistsUserId() = dao.isRecordExistsUserId()
}