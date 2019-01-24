package com.example.baseapplicationjetpack.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "posts")
data class PostEntity(
    @PrimaryKey
    var id : Int,
    var title: String

)
