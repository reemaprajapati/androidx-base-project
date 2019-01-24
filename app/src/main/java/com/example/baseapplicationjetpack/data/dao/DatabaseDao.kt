package com.example.baseapplicationjetpack.data.dao

import androidx.room.Dao
import com.example.baseapplicationjetpack.data.entities.PostEntity

@Dao
interface DatabaseDao: BaseDao<PostEntity>{

}