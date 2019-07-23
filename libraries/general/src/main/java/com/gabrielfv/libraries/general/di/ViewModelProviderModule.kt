package com.gabrielfv.libraries.general.di

import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelProviderModule<A : AppCompatActivity, VM : ViewModel>(
    private val klass: KClass<VM>
) {
    @Provides
    fun providesViewModelFactory(
        @AsViewModel provider: Provider<VM>
    ) = DaggerViewModelFactory(klass, provider)

    @Provides
    fun providesViewModel(
        activity: A,
        factory: DaggerViewModelFactory<@JvmSuppressWildcards VM>
    ) = ViewModelProvider(activity, factory)[klass.java]
}