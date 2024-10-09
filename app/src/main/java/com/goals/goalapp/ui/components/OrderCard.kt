package com.goals.goalapp.ui.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * Карточка активных заказов в списке
 *
 * полезные параметры
 *
 * название заказа
 * магазин
 * человек, который создал заказ
 * описание
 * время до окончания
 * кнопка принять учавстие
 */
@Composable
fun OrderCard() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F5F7),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Из самоката поклонка",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Магазин - Вкусвил",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )

            Text(
                text = "Только напитки",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Text(
                text = "Заказ от: Вася Петечкин",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Заказ до 14:25",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Присоединиться",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = ""
                    )
                }
            }
        }

    }
}

@Composable
fun OrderCard2() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F5F7),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Для своих кутуза",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Магазин - самокат",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )

            Text(
                text = "-",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Text(
                text = "Заказ от: Мария Черных",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Заказ до 14:40",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Присоединиться",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = ""
                    )
                }
            }
        }

    }
}

@Composable
fun OrderCard3() {
    Card(
        colors = CardDefaults.cardColors(
            containerColor = Color(0xFFF3F5F7),
        ),
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
            .padding(vertical = 8.dp, horizontal = 8.dp)
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .padding(start = 16.dp, end = 16.dp, top = 16.dp, bottom = 8.dp)
        ) {
            Text(
                text = "Дринкит у офиса",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold
            )

            Text(
                text = "Магазин - дринкит",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontSize = 15.sp,
            )

            Text(
                text = "-",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Text(
                text = "Заказ от: Дмитрий Смелый",
                modifier = Modifier.padding(2.dp),
                textAlign = TextAlign.Center,
                fontSize = 15.sp,
            )

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .weight(1F),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = "Заказ до 14:40",
                    textAlign = TextAlign.Center,
                    fontSize = 15.sp,
                )
                Row(
                    modifier = Modifier
                        .clip(RoundedCornerShape(12.dp))
                        .background(Color.White),
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Text(
                        text = "Присоединиться",
                        modifier = Modifier.padding(start = 16.dp, end = 16.dp, top = 4.dp, bottom = 4.dp),
                        color = Color.Black,
                        fontSize = 16.sp,
                    )
                    Icon(
                        modifier = Modifier.size(28.dp),
                        imageVector = Icons.Outlined.KeyboardArrowRight,
                        tint = MaterialTheme.colorScheme.secondary,
                        contentDescription = ""
                    )
                }
            }
        }

    }
}

@Composable
@Preview
fun OrderCardPreview() {
    OrderCard()
}
