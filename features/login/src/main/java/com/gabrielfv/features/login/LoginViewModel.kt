package com.gabrielfv.features.login

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.gabrielfv.libraries.data.GithubApi
import javax.inject.Inject

class LoginViewModel
@Inject constructor(
    private val api: GithubApi
): ViewModel() {

    fun makeLogin(username: String, password: String): LiveData<Boolean> {
        val success = MutableLiveData<Boolean>()
        val response = api.login(username, password)
        success.value = response

        return success
    }
}