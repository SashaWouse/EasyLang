package com.example.easylang.screens

import androidx.lifecycle.ViewModel
import com.example.easylang.repository.AuthRepository

class LoginViewModel(
    private val repository: AuthRepository = AuthRepository()
):ViewModel() {

}