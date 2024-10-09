package com.goals.goalapp.ui.login

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.goals.goalapp.R
import com.goals.goalapp.Screen
import com.goals.goalapp.login.presentation.LoginViewModel
import org.koin.androidx.compose.koinViewModel

@Composable
fun LoginScreen(navController: NavController, userViewModel: LoginViewModel = koinViewModel()) {

    val image = painterResource(id = R.drawable.tea_cup_coffee)

    val context = LocalContext.current

    val passwordVector = Icons.Filled.Lock
    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    val loginState by userViewModel.loginStateResponse.collectAsStateWithLifecycle()

    if (loginState) {
        navController.popBackStack()

        navController.navigate(Screen.AppScaffold.route) {

            popUpTo(navController.graph.startDestinationId)
            launchSingleTop = true
        }
        userViewModel.setStateFalse()
        Toast.makeText(LocalContext.current, "Успешно!", Toast.LENGTH_LONG).show()
    }

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
                text = "Авторизация",
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp
            )

            Spacer(modifier = Modifier.padding(10.dp))

            Column(horizontalAlignment = Alignment.CenterHorizontally) {

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
                    onClick = {
                        navController.popBackStack()

                        navController.navigate(Screen.AppScaffold.route) {

                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }
                        // userViewModel.login(context, emailValue.value, passwordValue.value)
                    }
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        text = "Войти"
                    )
                }
                Spacer(modifier = Modifier.padding(20.dp))
                Text(
                    text = "Создать аккаунт",
                    fontWeight = FontWeight.Bold,
                    color = Color.Gray,
                    modifier = Modifier.clickable(onClick = {
                        navController.navigate(Screen.RegisterScreen.route) {
                            popUpTo(navController.graph.startDestinationId)
                            launchSingleTop = true
                        }

                    })
                )
                Spacer(modifier = Modifier.padding(20.dp))
            }
        }
    }
}
