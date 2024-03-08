package com.tlw.composeCalculator.ui.customUI

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.ui.theme.CalculatorTheme
import androidx.compose.runtime.State

@Composable
fun ResultHistoryUI(resultState: State<List<ResultEntity>>) {
    val result = resultState.value

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (result.isNotEmpty()) {
            LazyColumn {
                items(result) { item ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(Color.White)
                    ) {
                        Text(
                            text = "${item.number1}${item.operation}${item.number2}",
                            textAlign = TextAlign.Right,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 2
                        )
                        Text(
                            text = "=${item.result}",
                            textAlign = TextAlign.Right,
                            modifier = Modifier
                                .fillMaxWidth(),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Bold,
                            maxLines = 2
                        )
                    }
                }
            }
        }
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview4() {
    CalculatorTheme {
//        ResultHistoryUI(mutableListOf())
    }
}