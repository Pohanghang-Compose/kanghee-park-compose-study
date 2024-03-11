package com.example.pohanghang.ui.signup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class SignUpViewModelFactory():ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(SignUpViewModel::class.java)) {
            @Suppress("UNCHECKED_CAST")
            return SignUpViewModel() as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}