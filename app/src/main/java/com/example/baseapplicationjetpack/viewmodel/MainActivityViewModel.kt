package com.example.baseapplicationjetpack.viewmodel

import androidx.lifecycle.ViewModel
import com.example.baseapplicationjetpack.data.entities.PostEntity
import com.example.baseapplicationjetpack.repository.Repository
import io.reactivex.Observable

class MainActivityViewModel constructor(var repository: Repository) : ViewModel() {
    fun insertPost(post: PostEntity) = repository.insertPost(post)
    fun getPosts(): Observable<List<PostEntity>> = repository.getPosts()
}