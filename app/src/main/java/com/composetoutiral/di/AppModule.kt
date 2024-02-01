package com.composetoutiral.di

import android.content.Context
import androidx.room.Room
import com.composetoutiral.datastore.DataStoreManager
import com.composetoutiral.datastore.DataStoreRepo
import com.composetoutiral.db.LoginDatabase
import com.composetoutiral.db.LoginEntity
import com.composetoutiral.utils.LoginConstants
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun provideDatabase(@ApplicationContext context: Context) = Room.databaseBuilder(
        context, LoginDatabase::class.java, LoginConstants.LOGIN_DATABASE
    ).allowMainThreadQueries().fallbackToDestructiveMigration().build()

    @Provides
    @Singleton
    fun provideDao(db: LoginDatabase) = db.loginDao()

    @Provides
    @Singleton
    fun provideEntity() = LoginEntity()

    @Singleton
    @Provides
    fun provideDataStoreRepository(
        @ApplicationContext context: Context,
    ): DataStoreRepo = DataStoreManager(context)

}