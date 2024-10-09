package com.goals.goalapp.ui.login

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.goals.goalapp.R
import com.goals.goalapp.Screen

@Composable
fun RegisterScreen(navController: NavController) {
    val image = painterResource(id = R.drawable.tea_cup_coffee)

    val passwordVector =  Icons.Filled.Lock
    val confirmPasswordValue = remember { mutableStateOf("") }
    val confirmPasswordVisibility = remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White),
            contentAlignment = Alignment.TopCenter
        ) {

            Image(
                painter = image, contentDescription = "Login main image",
                contentScale = ContentScale.Crop,
                modifier = Modifier
                    .padding(top = 100.dp)
                    .size(200.dp)
            )

        }

        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.60f)
                .clip(RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp))
                .background(Color.White)
                .padding(10.dp)
                .verticalScroll(rememberScrollState())
        ) {
            Text(
                text = "Регистрация",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))
            Column(horizontalAlignment = Alignment.CenterHorizontally) {

                LoginBaseItem()

                OutlinedTextField(
                    value = confirmPasswordValue.value,
                    onValueChange = { confirmPasswordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            confirmPasswordVisibility.value = !confirmPasswordVisibility.value
                        }) {
                            Icon(
                                imageVector = passwordVector, contentDescription = "Password icon",
                                tint = if (confirmPasswordVisibility.value) MaterialTheme.colorScheme.primary else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = "Подтвердите пароль") },
                    placeholder = { Text(text = "Подтвердите пароль") },
                    singleLine = true,
                    visualTransformation = if (confirmPasswordVisibility.value) VisualTransformation.None
                    else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)

                )

                Spacer(modifier = Modifier.padding(10.dp))
                Button(
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color(0xFFEDEFF2),
                        contentColor = Color.Black
                    ),
                    elevation = null,
                    shape = RoundedCornerShape(16.dp),
                    modifier = Modifier
                        .padding(top = 32.dp, end = 16.dp, start = 16.dp)
                        .fillMaxWidth(),
                    onClick = {}
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        text = "Регистрация"
                    )
                }
                Spacer(modifier = Modifier.padding(10.dp))
                Text(
                    text = "Вход в существующий аккаунт", fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.LoginScreen.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                    })
                )
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}
