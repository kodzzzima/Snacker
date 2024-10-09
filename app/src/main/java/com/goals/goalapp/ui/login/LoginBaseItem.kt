package com.goals.goalapp.ui.login

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import com.goals.goalapp.R

@Composable
fun LoginBaseItem() {

    val passwordVector =  Icons.Filled.Lock
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    OutlinedTextField(
        value = emailValue.value,
        onValueChange = { emailValue.value = it },
        label = { Text(text = "Логин") },
        placeholder = { Text(text = "Введите логин") },
        singleLine = true,
        modifier = Modifier.fillMaxWidth(0.8f),
    )

    OutlinedTextField(
        value = passwordValue.value,
        onValueChange = { passwordValue.value = it },
        trailingIcon = {
            IconButton(onClick = {
                passwordVisibility.value = !passwordVisibility.value
            }) {
                Icon(
                    imageVector = passwordVector, contentDescription = "Password icon",
                    tint = if (passwordVisibility.value) MaterialTheme.colorScheme.primary else Color.Gray
                )
            }
        },
        label = { Text(text = "Пароль") },
        placeholder = { Text(text = "Введите пароль") },
        singleLine = true,
        visualTransformation = if (passwordVisibility.value) VisualTransformation.None
        else PasswordVisualTransformation(),
        modifier = Modifier.fillMaxWidth(0.8f)
    )
}
