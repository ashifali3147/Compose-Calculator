package com.tlw.composeCalculator.ui.customUI

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.ui.theme.CalculatorTheme

@Composable
fun ResultHistoryUI(_result: MutableState<MutableList<ResultEntity>>) {
    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        val result by _result
        Log.e("sldkvnslkvn", "Size: ${result.size}")
        if (result.size > 0) {
            LazyColumn {
                items(result.size, key = { result[it].id!! }) { position ->
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(2.dp)
                            .background(Color.White)
                    ) {
                        Text(
                            text = "${result[position].number1}${result[position].operation}${result[position].number2}",
                            textAlign = TextAlign.Right,
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 5.dp),
                            fontSize = 20.sp,
                            fontWeight = FontWeight.Normal,
                            maxLines = 2
                        )
                        Text(
                            text = "=${result[position].result}",
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