package com.example.baseapplicationjetpack.repository

import android.util.Log
import com.example.baseapplicationjetpack.data.dao.DatabaseDao
import com.example.baseapplicationjetpack.data.entities.PostEntity
import com.example.baseapplicationjetpack.utility.ApiServiceProvider
import io.reactivex.Completable
import io.reactivex.CompletableObserver
import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repository
@Inject constructor(var databaseDao: DatabaseDao, var apiServiceProvider: ApiServiceProvider) {
    var TAG = "Repository"
    fun insertPost(post: PostEntity) {
        Completable.fromAction { databaseDao.insert(post) }
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(object : CompletableObserver {
                override fun onComplete() {
                    Log.d(TAG, "completed")
                }

                override fun onSubscribe(d: Disposable) {
                }

                override fun onError(e: Throwable) {
                    Log.d(TAG, "error $e")
                }
            })
    }

    fun getPosts() : Observable<List<PostEntity>>{
       return apiServiceProvider.getApiService().getPosts()
           .subscribeOn(Schedulers.io())
           .observeOn(AndroidSchedulers.mainThread())
    }
}