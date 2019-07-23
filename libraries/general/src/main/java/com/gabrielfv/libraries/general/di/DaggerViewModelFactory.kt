package com.gabrielfv.libraries.general.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Provider
import kotlin.reflect.KClass

class DaggerViewModelFactory<out VM : ViewModel>(
    private val klass: KClass<VM>,
    private val provider: Provider<VM>
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (klass.java.isAssignableFrom(modelClass)) {
            provider.get()
        } else {
            null
        } as T
    }
}