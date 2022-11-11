package com.example.theshoestore.screens.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {
    var email: MutableLiveData<String> = MutableLiveData<String>()
    var password: MutableLiveData<String> = MutableLiveData<String>()

    private val _errorMessage: MutableLiveData<String> = MutableLiveData<String>()
    val errorMessage: LiveData<String> get() = _errorMessage

    private val _completeLogin: MutableLiveData<Boolean> = MutableLiveData(false)
    val completeLogin: LiveData<Boolean> get() = _completeLogin

    fun onLoginClick() {
        if (email.value.isNullOrBlank()) {
            _errorMessage.value = "Email Can't be blank"
        } else if (password.value.isNullOrBlank())
            _errorMessage.value = "Password Can't be blank"
        else {
            _errorMessage.value = ""
            _completeLogin.value = true
        }
    }

    fun onLoginComplete() {
        _completeLogin.value = false
    }

}