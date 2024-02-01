package com.composetoutiral.datastore

interface DataStoreRepo {
    suspend fun putString(key: String, value: String)
    suspend fun getString(key: String): String?
}