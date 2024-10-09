package com.goals.goalapp.ui.bottombar

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.outlined.AccountCircle
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goals.goalapp.R
import com.goals.goalapp.ui.components.OrderCard
import com.goals.goalapp.ui.components.OrderCard2
import com.goals.goalapp.ui.components.OrderCard3

@Composable
fun HomeScreen() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background),
    ) {
        item {
            OrderCard()
        }
        item {
            OrderCard2()
        }
        item {
            OrderCard3()
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar() {
    var displayMenu by remember { mutableStateOf(false) }

    val context = LocalContext.current

    TopAppBar(
        title = {
            Box(
                modifier = Modifier
                    .padding(8.dp)
                    .wrapContentSize()
                    .clip(CircleShape)
                    .background(MaterialTheme.colorScheme.primaryContainer),
                contentAlignment = Alignment.Center
            ) {
                Image(
                    painter = painterResource(id = R.drawable.tea_cup_coffee),
                    contentDescription = "",
                    modifier = Modifier
                        .padding(8.dp)
                        .size(40.dp)
                )
                Text(
                    text = "Снэкер",
                    fontWeight = FontWeight.Bold,
                    fontSize = 10.sp,
                    color = Color.White
                )
            }
        },
        actions = {
            Text(
                text = "3",
                fontWeight = FontWeight.Bold,
                fontSize = 16.sp,
                color = Color.Red
            )

            Image(
                painter = painterResource(id = R.drawable.flame_danger),
                contentDescription = "",
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .size(48.dp)
            )

            // Creating a dropdown menu
            DropdownMenu(
                expanded = displayMenu,
                onDismissRequest = { displayMenu = false }
            ) {

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(
                    onClick = { Toast.makeText(context, "Settings", Toast.LENGTH_SHORT).show() },
                    text = { Text(text = "Settings") }
                )

                // Creating dropdown menu item, on click
                // would create a Toast message
                DropdownMenuItem(
                    onClick = {
                        Toast.makeText(context, "Logout", Toast.LENGTH_SHORT).show()
                    },
                    text = { Text(text = "Logout") }
                )
            }
        }
    )
}
