package com.example.baseapplicationjetpack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.baseapplicationjetpack.data.dao.DatabaseDao
import com.example.baseapplicationjetpack.data.entities.PostEntity

@Database(entities = [PostEntity::class], version = 1, exportSchema = false)
abstract class TestDatabase : RoomDatabase() {

    abstract fun databaseDao() : DatabaseDao

}