package com.example.pohanghang.ui.signup

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class SignUpViewModel() : ViewModel() {
    private val _id = mutableStateOf("")
    private val _pw = mutableStateOf("")
    private val _nickname = mutableStateOf("")
    private val _isSignUp = mutableStateOf(false)
    val isSignUp: State<Boolean> = _isSignUp

    private fun checkSignUpValid() {
        _isSignUp.value =
            !(_id.value.isNullOrEmpty() || _pw.value.isNullOrEmpty() || _nickname.value.isNullOrEmpty())
    }

    fun updateId(id: String) {
        _id.value = id
        checkSignUpValid()
    }

    fun updatePw(pw: String) {
        _pw.value = pw
        checkSignUpValid()
    }

    fun updateNickname(nickname: String) {
        _nickname.value = nickname
        checkSignUpValid()
    }

    fun removeValue() {
        _isSignUp.value = false
        _id.value = ""
        _pw.value = ""
        _nickname.value = ""
    }
}