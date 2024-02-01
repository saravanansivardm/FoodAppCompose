package com.composetoutiral.db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.composetoutiral.utils.LoginConstants

@Entity(tableName = LoginConstants.LOGIN_TABLE)
data class LoginEntity(
    @PrimaryKey(autoGenerate = true)
    val userId: Int = 0,
    @ColumnInfo(name = "full_name")
    val userFullName: String = "",
    @ColumnInfo(name = "email")
    val userEmail: String = "",
    @ColumnInfo(name = "phone")
    val userPhone: String = "",
)