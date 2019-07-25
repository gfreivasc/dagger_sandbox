package com.gabrielfv.libraries.common.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelStoreOwner
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelProviderModule<S : ViewModelStoreOwner, VM : ViewModel>(
    private val vmClass: KClass<VM>
) {
    @Provides
    fun providesViewModelFactory(
        provider: Provider<VM>
    ) = DaggerViewModelFactory(vmClass, provider)

    @Provides
    fun providesViewModelProvider(
        storeOwner: S,
        factory: DaggerViewModelFactory<@JvmSuppressWildcards VM>
    ) = DaggerViewModelProvider(
        storeOwner,
        factory,
        vmClass
    )
}