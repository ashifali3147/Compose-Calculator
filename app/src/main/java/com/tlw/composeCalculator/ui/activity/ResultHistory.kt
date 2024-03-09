package com.tlw.composeCalculator.ui.activity

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tlw.composeCalculator.ui.customUI.ResultHistoryUI
import com.tlw.composeCalculator.ui.theme.CalculatorTheme
import com.tlw.composeCalculator.ui.viewmodel.ResultHistoryViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ResultHistory : ComponentActivity() {
    @SuppressLint("SuspiciousIndentation")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                // A surface container using the 'background' color from the theme
                val viewModel = viewModel<ResultHistoryViewModel>()
                val resultState = viewModel.resultEntity.collectAsState(initial = emptyList())


                ResultHistoryUI(resultState, viewModel)
            }
        }
    }
}

@Composable
fun Greeting2(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!", modifier = modifier
    )
}

@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview3() {
    CalculatorTheme {
//        ResultHistoryUI(mutableListOf(ResultEntity()))
    }
}