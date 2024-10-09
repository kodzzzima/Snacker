package com.goals.goalapp.ui.bottombar.friends

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun FriendsScreen() {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Top
    ) {
        Text(
            modifier = Modifier.padding(),
            fontSize = 20.sp,
            text = "Список друзей"
        )
        Column {
            Row {
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "1) "
                )
                Text(
                    modifier = Modifier.padding(top = 16.dp),
                    text = "Тут пусто"
                )
            }
        }
    }
}

@Composable
@Preview
fun FriendsScreenPreview() {
    FriendsScreen()
}
