package com.thomson.testapp.login

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val loginRepository: LoginRepository
) : ViewModel() {

    private val _loginState: MutableStateFlow<LoginState> = MutableStateFlow(LoginState.Unknown)
    val loginState: StateFlow<LoginState> = _loginState

    fun login(userName: String, password: String) {
        viewModelScope.launch {
            loginRepository.login(userName = userName, password = password)
                .onSuccess { _loginState.value = LoginState.Success }
                .onFailure { _loginState.value = LoginState.Failed(it.localizedMessage.orEmpty()) }
        }
    }
}

sealed class LoginState {
    object Success : LoginState()
    object Unknown : LoginState()
    class Failed(val message: String) : LoginState()
}