package com.raywenderlich.android.lab1.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import com.raywenderlich.android.lab1.R
import com.raywenderlich.android.lab1.router.BackButtonHandler
import com.raywenderlich.android.lab1.router.FundamentalsRouter
import com.raywenderlich.android.lab1.router.Screen
import androidx.compose.material.Text
import androidx.compose.material.TextFieldDefaults
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun TextFieldScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        MyTextField()
    }

    BackButtonHandler {
        FundamentalsRouter.navigateTo(Screen.Navigation)
    }
}

@Composable
fun MyTextField() {
    val textValue = remember { mutableStateOf("")}

    val primaryColor = colorResource(id = R.color.purple_500)

    OutlinedTextField(
        label = {Text(text = stringResource(id = R.string.insert_email))},
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = primaryColor,
            focusedLabelColor = primaryColor,
            cursorColor = primaryColor
        ),
        keyboardOptions = KeyboardOptions.Default.copy(keyboardType = KeyboardType.Email),
        value = textValue.value,
        onValueChange = {
            textValue.value = it
        },

        )


}