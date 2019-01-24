package com.example.baseapplicationjetpack.di

import com.example.baseapplicationjetpack.di.activitymodule.MainActivityModule
import com.example.baseapplicationjetpack.ui.activities.MainActivity
import com.example.baseapplicationjetpack.ui.fragments.HomeFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class ActivityBuilder{

    @ContributesAndroidInjector(modules = [MainActivityModule::class])
    abstract fun bindMainActivity() : MainActivity

    @ContributesAndroidInjector()
    abstract fun bindHomeFragment() : HomeFragment

}
