package com.gabrielfv.features.login

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.gabrielfv.feature.login.R
import com.gabrielfv.libraries.general.di.AsViewModel
import dagger.android.AndroidInjection
import kotlinx.android.synthetic.main.activity_login.*
import javax.inject.Inject

class LoginActivity : AppCompatActivity() {
    @Inject
    @AsViewModel
    lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
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
            }
        }
    }
}
