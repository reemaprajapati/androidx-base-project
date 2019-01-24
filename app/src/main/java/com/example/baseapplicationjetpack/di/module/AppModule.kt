package com.example.baseapplicationjetpack.di.module

import android.app.Application
import android.content.Context
import androidx.room.Room
import com.example.baseapplicationjetpack.data.TestDatabase
import com.example.baseapplicationjetpack.data.constants.Database.DATABASE_NAME
import com.example.baseapplicationjetpack.utility.ApiServiceProvider
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AppModule {
    @Provides
    @Singleton
    fun provideApplicationContext(application: Application): Context = application.applicationContext

    @Provides
    @Singleton
    fun provideDatabase(application: Application): TestDatabase {
        val labelDatabase: TestDatabase = Room
            .databaseBuilder(
                application.applicationContext,
                TestDatabase::class.java, DATABASE_NAME
            )
            .fallbackToDestructiveMigration()
//                .allowMainThreadQueries()
            .build()
        return labelDatabase
    }

    @Provides
    @Singleton
    fun provideDao(database: TestDatabase) = database.databaseDao()

    @Provides
    @Singleton
    fun provideServiceProvider(): ApiServiceProvider {
        return ApiServiceProvider()
    }
}
