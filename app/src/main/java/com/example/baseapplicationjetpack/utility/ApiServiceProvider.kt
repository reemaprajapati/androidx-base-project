package com.example.baseapplicationjetpack.utility

import com.example.baseapplicationjetpack.api.ApiService
import com.example.baseapplicationjetpack.di.DaggerNetworkComponent
import com.example.baseapplicationjetpack.di.NetworkComponent
import com.example.baseapplicationjetpack.di.module.NetworkModule

class ApiServiceProvider {
    fun getApiService(): ApiService {
        var component: NetworkComponent = DaggerNetworkComponent
            .builder()
            .networkModule(NetworkModule())
            .build()
        return component.provideApiService()
    }
}