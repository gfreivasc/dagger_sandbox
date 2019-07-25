package com.gabrielfv.libraries.common

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModel
import com.gabrielfv.libraries.common.di.viewmodel.DaggerViewModelProvider
import dagger.android.AndroidInjection
import javax.inject.Inject

abstract class ViewModelActivity<VM : ViewModel> : AppCompatActivity() {
    @Inject
    lateinit var viewModelProvider: DaggerViewModelProvider<VM>
    lateinit var viewModel: VM

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        viewModel = viewModelProvider.run { get(vmClass.java) }
        super.onCreate(savedInstanceState)
    }
}