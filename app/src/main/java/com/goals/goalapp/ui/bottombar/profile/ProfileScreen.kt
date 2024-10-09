package com.goals.goalapp.ui.bottombar.profile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material.icons.outlined.Face
import androidx.compose.material.icons.outlined.Info
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material.icons.outlined.Settings
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.goals.goalapp.R
import com.goals.goalapp.Screen
import org.koin.androidx.compose.koinViewModel

@Composable
fun ProfileScreen(
    navController: NavController,
    viewModel: ProfileViewModel = koinViewModel(),
    logout: () -> Unit,
) {
    val uiState by viewModel.state.collectAsStateWithLifecycle()

    if (uiState.isExit) {
        viewModel.setExitStateFalse()
        navController.navigate(Screen.LoginScreen.route)
    }

    if (uiState.isFriendsAction) {
        viewModel.onFriendsClickHandled()
        navController.navigate(Screen.Friends.route)
    }

    uiState.data?.let { state ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(MaterialTheme.colorScheme.background),
            contentAlignment = Alignment.Center
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState()),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Top
            ) {

                Column(
                    modifier = Modifier
                        .wrapContentHeight()
                        .weight(1f, fill = false),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Top
                ) {
                    Image(
                        modifier = Modifier
                            .size(150.dp)
                            .clip(CircleShape),
                        painter = painterResource(id = R.drawable.happy_student),
                        contentDescription = "Изображение пользователя",
                    )
                    Row(
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = "Очки кармы: ",
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Red
                        )
                        Text(
                            modifier = Modifier.padding(top = 8.dp),
                            text = state.balance.toString(),
                            fontWeight = FontWeight.Bold,
                            fontSize = 16.sp,
                            color = Color.Red
                        )
                        Image(
                            painter = painterResource(id = R.drawable.flame_danger),
                            contentDescription = "",
                            modifier = Modifier
                                .padding(horizontal = 8.dp)
                                .padding(top = 8.dp)
                                .size(24.dp),
                        )
                    }
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        text = state.firstName + " " + state.secondName,
                        fontWeight = FontWeight.Bold,
                        color = Color.Black,
                        fontSize = 20.sp
                    )
                    Text(
                        modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp),
                        text = state.email,
                        color = Color.Black,
                        fontSize = 18.sp
                    )
                    ProfileItem1(
                        onClick = {
                            navController.navigate(Screen.Friends.route)
                        }
                    )
                    ProfileItem2(
                        onClick = {
                            navController.navigate(Screen.Friends.route)
                        }
                    )
                    ProfileItem3(
                        onClick = {
                            navController.navigate(Screen.Friends.route)
                        }
                    )
                }

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
                        logout.invoke()
                    }
                ) {
                    Text(
                        modifier = Modifier.padding(8.dp),
                        fontSize = 18.sp,
                        letterSpacing = 1.sp,
                        text = "Выйти"
                    )
                }
            }
        }
    }
}

@Composable
fun ProfileItem1(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(36.dp),
                imageVector = Icons.Outlined.Face, contentDescription = ""
            )
            Text(
                text = "Друзья",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = ""
        )
    }
}

@Composable
fun ProfileItem2(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(36.dp),
                imageVector = Icons.Outlined.Settings, contentDescription = ""
            )
            Text(
                text = "Настройки",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = ""
        )
    }
}

@Composable
fun ProfileItem3(
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .wrapContentHeight()
            .clickable {
                onClick.invoke()
            },
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Icon(
                modifier = Modifier
                    .padding(start = 16.dp, end = 16.dp)
                    .size(36.dp),
                imageVector = Icons.Outlined.Info, contentDescription = ""
            )
            Text(
                text = "О приложении",
                modifier = Modifier.padding(start = 16.dp, end = 16.dp),
                color = Color.Black,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Icon(
            modifier = Modifier.size(28.dp),
            imageVector = Icons.Outlined.KeyboardArrowRight,
            tint = MaterialTheme.colorScheme.secondary,
            contentDescription = ""
        )
    }
}
