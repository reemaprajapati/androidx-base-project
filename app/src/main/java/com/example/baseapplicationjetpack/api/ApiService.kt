package com.example.baseapplicationjetpack.api

import com.example.baseapplicationjetpack.data.constants.StringConstants
import com.example.baseapplicationjetpack.data.entities.PostEntity
import io.reactivex.Observable
import retrofit2.http.GET
import java.util.*

interface ApiService {
    @GET(StringConstants.POSTS)
    fun getPosts(): Observable<List<PostEntity>>
}