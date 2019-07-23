package com.gabrielfv.features.login.di

import com.gabrielfv.features.login.LoginActivity
import com.gabrielfv.features.login.LoginViewModel
import com.gabrielfv.libraries.data.GithubApi
import com.gabrielfv.libraries.general.di.AsViewModel
import com.gabrielfv.libraries.general.di.PerScreen
import com.gabrielfv.libraries.general.di.ViewModelProviderModule
import dagger.Module
import dagger.Provides
import dagger.android.ContributesAndroidInjector

@Module
interface LoginModule {

    @PerScreen
    @ContributesAndroidInjector(modules = [Providers::class])
    fun contributesInjector(): LoginActivity

    @Module
    class Providers : ViewModelProviderModule<LoginActivity, LoginViewModel>(LoginViewModel::class) {

        @Provides
        @AsViewModel
        fun providerInternalViewModel(api: GithubApi) = LoginViewModel(api)
    }
}