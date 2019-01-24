package com.example.baseapplicationjetpack

import android.app.Activity
import android.app.Application
import androidx.fragment.app.Fragment
import com.example.baseapplicationjetpack.di.DaggerAppComponent
import com.facebook.stetho.Stetho
import dagger.android.*
import dagger.android.support.HasSupportFragmentInjector
import javax.inject.Inject

class MainApplication : Application(), HasActivityInjector, HasSupportFragmentInjector {
    @Inject
    lateinit var activityDispatchingAndroidInjector: DispatchingAndroidInjector<Activity>
    @Inject
    lateinit var supportFragmentDispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>

    override fun onCreate() {
        super.onCreate()

        Stetho.initializeWithDefaults(this);
        DaggerAppComponent.builder()
            .application(this)
            .build()
            .inject(this)
    }

    override fun activityInjector(): AndroidInjector<Activity> = activityDispatchingAndroidInjector
    override fun supportFragmentInjector(): AndroidInjector<Fragment> = supportFragmentDispatchingAndroidInjector
}