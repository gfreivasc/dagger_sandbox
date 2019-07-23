package com.gabrielfv.github

import android.app.Application
import com.gabrielfv.github.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasAndroidInjector
import javax.inject.Inject

class GithubApp : Application(), HasAndroidInjector {
    @Inject
    lateinit var androidInjector: DispatchingAndroidInjector<Any>

    override fun onCreate() {
        DaggerAppComponent.factory()
            .create(this)
            .inject(this)

        super.onCreate()
    }

    override fun androidInjector(): AndroidInjector<Any> = androidInjector
}