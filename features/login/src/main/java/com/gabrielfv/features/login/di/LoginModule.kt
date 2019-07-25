package com.gabrielfv.features.login.di

import com.gabrielfv.features.login.LoginActivity
import com.gabrielfv.features.login.LoginViewModel
import com.gabrielfv.libraries.common.di.PerScreen
import com.gabrielfv.libraries.common.di.viewmodel.ViewModelProviderModule
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
interface LoginModule {

    @PerScreen
    @ContributesAndroidInjector(modules = [Providers::class])
    fun contributesInjector(): LoginActivity

    @Module
    class Providers : ViewModelProviderModule<LoginActivity, LoginViewModel>(LoginViewModel::class)
}