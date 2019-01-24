package com.example.baseapplicationjetpack.di.activitymodule

import com.example.baseapplicationjetpack.repository.Repository
import com.example.baseapplicationjetpack.viewmodel.MainActivityViewModel
import dagger.Module
import dagger.Provides

//This is not necessary if you're not using constructor and injecting in the viewmodel directly

@Module
class MainActivityModule{

    @Provides
    fun provideViewModel(repository: Repository) = MainActivityViewModel(repository)
}