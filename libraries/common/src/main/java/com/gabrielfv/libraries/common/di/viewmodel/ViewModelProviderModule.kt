package com.gabrielfv.libraries.common.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import com.gabrielfv.libraries.common.di.AsViewModel
import dagger.Module
import dagger.Provides
import javax.inject.Provider
import kotlin.reflect.KClass

@Module
abstract class ViewModelProviderModule<VM : ViewModel, S : ViewModelStoreOwner>(
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
    ) = ViewModelProvider(storeOwner, factory)

    @Provides
    @AsViewModel
    fun providesViewModel(
        vmProvider: ViewModelProvider
    ): VM = vmProvider[vmClass.java]
}