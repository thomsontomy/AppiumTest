package com.thomson.testapp.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun LoginScreen(loginViewModel: LoginViewModel = viewModel()) {
    val loginState = loginViewModel.loginState.collectAsState()
    Column(horizontalAlignment = Alignment.CenterHorizontally) {
        Text(
            modifier = Modifier
                .padding(4.dp)
                .testTag("title"),
            text = "App Login",
            fontSize = 24.sp
        )
        LoginView(onLogin = { userName, password ->
            loginViewModel.login(userName, password)
        })
        val authMessage = when (loginState.value) {
            LoginState.Success -> "Login Success"
            is LoginState.Failed -> (loginState.value as LoginState.Failed).message
            LoginState.Unknown -> "Unauthenticated"
        }
        Text(
            modifier = Modifier.testTag("authResult"),
            text = authMessage
        )
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    LoginScreen()
}