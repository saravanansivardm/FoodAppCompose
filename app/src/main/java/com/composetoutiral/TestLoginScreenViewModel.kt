package com.composetoutiral

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TestLoginScreenViewModel : ViewModel() {
    private val _emailError = MutableLiveData<String>()
    val emailError: LiveData<String> = _emailError


    private val _passwordError = MutableLiveData<String>()
    val passwordError: LiveData<String> = _passwordError

    private val _confirmPasswordError = MutableLiveData<String>()
    val confirmPasswordError: LiveData<String> = _confirmPasswordError

    private val _phoneError = MutableLiveData<String>()
    val phoneError: LiveData<String> = _phoneError

    fun validateEmail(email: String) {
        if (email.isEmpty()) {
            _emailError.value = "Email is required"
        } else if (!android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            _emailError.value = "Invalid email address"
        } else {
            _emailError.value = ""
        }
    }

    fun validatePassword(password: String) {
        if (password.isEmpty()) {
            _passwordError.value = "Password is required"
        } else if (password.length < 6) {
            _passwordError.value = "Password must be at least 6 characters"
        } else {
            _passwordError.value = ""
        }
    }

    fun validateConfirmPassword(password: String, confirmPassword: String) {
        if (confirmPassword.isEmpty()) {
            _confirmPasswordError.value = "Confirm Password is required"
        } else if (confirmPassword != password) {
            _confirmPasswordError.value = "Passwords do not match"
        } else {
            _confirmPasswordError.value = ""
        }
    }

    fun validatePhoneNumber(phoneNumber: String) {
        if (phoneNumber.isEmpty()) {
            _phoneError.value = "Phone Number is required"
        } else if (phoneNumber.length != 10) {
            _phoneError.value = "Phone Number must be 10 digits"
        } else {
            _phoneError.value = ""
        }
    }
}