package com.goals.goalapp.ui.bottombar

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.goals.goalapp.R

@Composable
fun MyOrders() {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
    ) {
        item {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "Текущие заказы",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        item {
            CurrentOrderCard()
        }
        item {
            CreateOrderCard()
        }
        item {
            Text(
                modifier = Modifier.padding(16.dp),
                text = "История заказов",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
        }
        item {
            Text(
                modifier = Modifier.padding(horizontal = 16.dp),
                text = "Пока пусто",
                fontSize = 16.sp
            )
        }
        // item {
        //     HistoryList()
        // }
    }
}

@Composable
fun CreateOrderCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F5F7),
        ),
        modifier = Modifier
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .fillMaxWidth()
            .height(100.dp)
            .clip(RoundedCornerShape(16.dp))
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Создать новый заказ",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Icon(
                imageVector = Icons.Outlined.AddCircle,
                contentDescription = "Создать новый заказ"
            )
        }
    }
}

@Composable
fun CurrentOrderCard() {
    Card(
        shape = RoundedCornerShape(16.dp),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.surfaceVariant,
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(150.dp)
            .clip(RoundedCornerShape(16.dp))
            .padding(vertical = 8.dp, horizontal = 8.dp)
            .clickable {

            }
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(
                            Color(0xFF36BA5F),
                            Color(0xFF85CF9F)
                        )
                    )
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier.padding(8.dp),
                text = "Заказ из вкусвила #1",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp
            )
            Text(
                modifier = Modifier
                    .padding(8.dp)
                    .padding(top = 8.dp),
                text = "Участников: 3",
                fontSize = 18.sp
            )
        }
    }
}

@Composable
fun HistoryList() {
    LazyVerticalGrid(columns = GridCells.Fixed(2)) {
        items(6) {
            HistoryItem()
        }
    }
}

@Composable
fun HistoryItem() {
    Card(
        shape = RoundedCornerShape(22.dp),
        modifier = Modifier
            .padding(8.dp)
            .height(200.dp)
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.surfaceVariant)
            .clip(shape = RoundedCornerShape(22.dp))
    ) {
        Text(
            modifier = Modifier.padding(8.dp),
            text = "Заказ",
            fontSize = 20.sp
        )
    }
}

@Preview
@Composable
fun CreateOrderCardPreview() {
    CreateOrderCard()
}

