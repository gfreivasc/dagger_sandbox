package com.gabrielfv.github.di

import com.gabrielfv.features.login.di.LoginModule
import com.gabrielfv.github.GithubApp
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import javax.inject.Singleton

@Singleton
@Component(modules = [
    LoginModule::class,
    AndroidSupportInjectionModule::class
])
interface AppComponent : AndroidInjector<GithubApp> {

    @Component.Factory
    interface Factory {
        fun create(@BindsInstance application: GithubApp): AppComponent
    }
}