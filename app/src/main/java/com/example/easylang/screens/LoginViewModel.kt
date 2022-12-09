package com.example.easylang.screens

import android.content.Context
import android.widget.Toast
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.easylang.repository.AuthRepository
import kotlinx.coroutines.launch
import kotlin.math.log

class LoginViewModel(
    private val repository: AuthRepository = AuthRepository()
):ViewModel() {
    val currentUser = repository.currentUser

    val hasUser: Boolean
        get() =repository.hasUser()

    var loginUiState by mutableStateOf(LoginUiState())
        private set

    fun  onUserNameChange(userName: String){
        loginUiState = loginUiState.copy(userName = userName)
    }

    fun  onUserPasswordChange(userPassword: String){
        loginUiState = loginUiState.copy(userPassword = userPassword)
    }

    fun  onUserNameChangeSignUp(userName: String){
        loginUiState = loginUiState.copy(userNameSignUp = userName)
    }

    fun  onUserPasswordChangeSignUp(userPassword: String){
        loginUiState = loginUiState.copy(userPasswordSignUp = userPassword)
    }

    fun  onConfirmPasswordChange(userPassword: String){
        loginUiState = loginUiState.copy(confirmPasswordSignUp = userPassword)
    }

    private fun validateLoginForm() =
        loginUiState.userName.isBlank() &&
                loginUiState.userPassword.isBlank()

    private fun validateSignUpForm() =
        loginUiState.userNameSignUp.isNotBlank() &&
                loginUiState.userPasswordSignUp.isNotBlank() &&
                loginUiState.confirmPasswordSignUp.isNotBlank()

    fun createUser(context: Context) = viewModelScope.launch {
        try {
            if (!validateSignUpForm()) {
                throw IllegalArgumentException("Email and password can not be empty!")
            }
            loginUiState = loginUiState.copy(isLoading = true)
            if (loginUiState.userPasswordSignUp != loginUiState.confirmPasswordSignUp){
                throw IllegalArgumentException("Password do not match!")
            }
            loginUiState = loginUiState.copy(signUpError = null)
            repository.createUser(
                loginUiState.userNameSignUp,
                loginUiState.userPasswordSignUp
            ){
                isSuccessful ->
                if (isSuccessful) {
                    Toast.makeText(context, "Success Login", Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = true)
                } else {
                    Toast.makeText(context, "Failed Login", Toast.LENGTH_SHORT).show()
                    loginUiState = loginUiState.copy(isSuccessLogin = false)
                }
            }


        } catch (e:Exception){
            loginUiState = loginUiState.copy(signUpError = e.localizedMessage)
            e.printStackTrace()
        } finally {
            loginUiState = loginUiState.copy(isLoading = false)
        }
    }

}

data class LoginUiState(
    val userName:String = "",
    val userPassword:String = "",
    val userNameSignUp:String = "",
    val userPasswordSignUp:String = "",
    val confirmPasswordSignUp:String = "",
    val isLoading:Boolean = false,
    val isSuccessLogin:Boolean = false,
    val signUpError:String? = null,
    val loginError:String? = null
)