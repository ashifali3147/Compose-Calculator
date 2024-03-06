package com.tlw.composeCalculator

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp


@Composable
fun CalculatorButton(
    symbol: String,
    modifier: Modifier = Modifier,
    onclick: () -> Unit,
    function: () -> Unit
)
{
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(CircleShape)
            .clickable { onclick() }
            .then(modifier)
    ) {
        Text(
            text = symbol, textAlign = TextAlign.Center,
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.White
        )
    }
}

//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    val setonclick: () -> Unit
//    CalculatorButton(symbol = "1")
//}