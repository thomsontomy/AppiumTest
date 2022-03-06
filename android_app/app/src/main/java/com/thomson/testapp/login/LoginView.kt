package com.thomson.testapp.login

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun LoginView(onLogin: (userName: String, password: String) -> Unit) {
    var userName by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    Column(modifier = Modifier.padding(4.dp)) {
        OutlinedTextField(
            modifier = Modifier.testTag("username"),
            value = userName,
            label = { Text(text = "User name") },
            onValueChange = { userName = it },
        )
        OutlinedTextField(
            modifier = Modifier.testTag("password"),
            value = password,
            label = { Text(text = "Password") },
            onValueChange = { password = it },
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password)
        )
        Button(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .testTag("loginButton"),
            onClick = { onLogin(userName, password) }) {
            Text(text = "Login")
        }
    }
}

@Preview
@Composable
fun LoginPreview() {
    LoginView { userName, password -> println("$userName, $password") }
}