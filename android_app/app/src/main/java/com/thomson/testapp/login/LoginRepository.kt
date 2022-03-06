package com.thomson.testapp.login

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.time.Duration

class LoginRepository @Inject constructor() {

    suspend fun login(userName: String, password: String): Result<Boolean> {
        return withContext(Dispatchers.IO) {
            // Fake login
            delay(2 * 1000)
            if (userName == "test" && password == "password") {
                Result.success(true)
            } else {
                Result.failure(Exception("Invalid username or password"))
            }
        }
    }
}