package com.gabrielfv.features.login

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import com.gabrielfv.feature.login.R
import com.gabrielfv.libraries.common.ViewModelActivity
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : ViewModelActivity<LoginViewModel>() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val usernameInput = usernameTextInput.editText
        val passwordInput = passwordTextInput.editText

        signInButton.setOnClickListener {
            val username = usernameInput?.text
                .takeIf { !it.isNullOrEmpty() }

            if (username == null) usernameTextInput.error = "Cannot be empty"

            val password = passwordInput?.text
                .takeIf { !it.isNullOrEmpty() }

            if (password == null) passwordTextInput.error = "Cannot be empty"

            if (password != null && username != null) {
                viewModel.makeLogin(username.toString(), password.toString())
                    .also { listenLoginStatus(it) }
            }
        }
    }

    fun listenLoginStatus(loginStatus: LiveData<Boolean>) {
        loginStatus.observe(this, Observer { success ->
            if (success) Toast.makeText(this, "Succeeded", Toast.LENGTH_LONG).show()
        })
    }
}
