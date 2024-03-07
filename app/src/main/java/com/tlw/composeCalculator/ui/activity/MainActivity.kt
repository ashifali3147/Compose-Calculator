package com.tlw.composeCalculator.ui.activity

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import com.tlw.composeCalculator.ui.customUI.CalculatorUI
import com.tlw.composeCalculator.ui.viewmodel.CalculatorViewModel
import com.tlw.composeCalculator.data.model.CalculatorState
import com.tlw.composeCalculator.ui.theme.CalculatorTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CalculatorTheme {
                val viewModel = viewModel<CalculatorViewModel>()
                val state = viewModel.state
                CalculatorUI(state = state, modifier = Modifier.fillMaxSize(), onAction = viewModel::onAction)
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculatorTheme {
        CalculatorUI(state = CalculatorState("12","10"), modifier = Modifier.fillMaxHeight(), onAction = {})
    }
}