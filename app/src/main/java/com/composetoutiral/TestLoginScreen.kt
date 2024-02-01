package com.composetoutiral

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.FocusRequester
import androidx.compose.ui.focus.focusRequester
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController

@Composable
fun TestLoginScreen(
    navController: NavController,
    viewModel: TestLoginScreenViewModel = hiltViewModel()
) {
    val context = LocalContext.current
    val emailError by viewModel.emailError.observeAsState("")
    val passwordError by viewModel.passwordError.observeAsState("")
    val confirmPasswordError by viewModel.confirmPasswordError.observeAsState("")
    val phoneError by viewModel.phoneError.observeAsState("")

    val emailFocusRequester = remember { FocusRequester() }
    val passwordFocusRequester = remember { FocusRequester() }
    val confirmPasswordFocusRequester = remember { FocusRequester() }
    val phoneFocusRequester = remember { FocusRequester() }

    var email by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }
    var confirmPassword by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        TextField(
            value = email,
            onValueChange = {
                email = it
            },
            label = { Text("Email") },
            isError = emailError.isNotEmpty(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { passwordFocusRequester.requestFocus() }
            ),
            modifier = Modifier.focusRequester(emailFocusRequester)
        )
        if (emailError.isNotEmpty()) {
            Text(text = emailError, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = password,
            onValueChange = {
                password = it
            },
            label = { Text("Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = passwordError.isNotEmpty(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { confirmPasswordFocusRequester.requestFocus() }
            ),
            modifier = Modifier.focusRequester(passwordFocusRequester)
        )
        if (passwordError.isNotEmpty()) {
            Text(text = passwordError, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = confirmPassword,
            onValueChange = {
                confirmPassword = it
            },
            label = { Text("Confirm Password") },
            visualTransformation = PasswordVisualTransformation(),
            isError = confirmPasswordError.isNotEmpty(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Next
            ),
            keyboardActions = KeyboardActions(
                onNext = { phoneFocusRequester.requestFocus() }
            ),
            modifier = Modifier.focusRequester(confirmPasswordFocusRequester)
        )
        if (confirmPasswordError.isNotEmpty()) {
            Text(text = confirmPasswordError, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))

        TextField(
            value = phoneNumber,
            onValueChange = {
                phoneNumber = it
            },
            label = { Text("Phone Number") },
            isError = phoneError.isNotEmpty(),
            keyboardOptions = KeyboardOptions.Default.copy(
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.focusRequester(phoneFocusRequester)
        )
        if (phoneError.isNotEmpty()) {
            Text(text = phoneError, color = MaterialTheme.colors.error)
        }

        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
//                emailFocusRequester.requestFocus()
                if (emailError.isNotEmpty()) {
                    emailFocusRequester.requestFocus()
                }
                viewModel.validateEmail(email)
                if (emailError.isEmpty()) {
                    passwordFocusRequester.requestFocus()
                    viewModel.validatePassword(password)
                    if (passwordError.isEmpty()) {
                        confirmPasswordFocusRequester.requestFocus()
                        viewModel.validateConfirmPassword(password, confirmPassword)
                        if (confirmPasswordError.isEmpty()) {
                            phoneFocusRequester.requestFocus()
                            viewModel.validatePhoneNumber(phoneNumber)
                            if (emailError.isEmpty() && passwordError.isEmpty() && confirmPasswordError.isEmpty() && phoneError.isEmpty()) {
                                Toast.makeText(context, "Yeaaa Successss", Toast.LENGTH_SHORT)
                                    .show()
                            }
                        }
                    }
                }
            },
        ) {
            Text("Submit")
        }
    }
}