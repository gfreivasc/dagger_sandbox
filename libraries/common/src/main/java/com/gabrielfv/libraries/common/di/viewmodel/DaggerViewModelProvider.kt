package com.gabrielfv.libraries.common.di.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner
import kotlin.reflect.KClass

class DaggerViewModelProvider<VM : ViewModel>(
    storeOwner: ViewModelStoreOwner,
    factory: DaggerViewModelFactory<VM>,
    val vmClass: KClass<VM>
) : ViewModelProvider(storeOwner, factory)