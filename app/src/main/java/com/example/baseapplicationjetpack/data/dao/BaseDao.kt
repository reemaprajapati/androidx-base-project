package com.example.baseapplicationjetpack.data.dao

import android.icu.lang.UCharacter.GraphemeClusterBreak.T
import androidx.room.*

@Dao
interface BaseDao<T>{

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg entity: T)

    @Delete
    fun delete(entity : T)

    @Update
    fun update(entity: T)
}