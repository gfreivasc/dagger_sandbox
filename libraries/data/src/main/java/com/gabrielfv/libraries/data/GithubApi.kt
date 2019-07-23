package com.gabrielfv.libraries.data

import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class GithubApi @Inject constructor() {

    fun login(username: String, password: String) = true
}