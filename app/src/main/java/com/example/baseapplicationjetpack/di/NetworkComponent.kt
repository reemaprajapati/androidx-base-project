package com.example.baseapplicationjetpack.di

import com.example.baseapplicationjetpack.api.ApiService
import com.example.baseapplicationjetpack.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface NetworkComponent {
    fun provideApiService(): ApiService
}