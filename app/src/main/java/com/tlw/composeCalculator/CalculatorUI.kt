package com.tlw.composeCalculator

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.composeCalculator.ui.theme.DarkPink

@Composable
fun CalculatorUI(state: CalculatorState, modifier: Modifier = Modifier, buttonSpacing: Dp = 8.dp, onAction: (CalculatorAction) -> Unit) {
    Box(
        modifier = modifier
            .background(Color.White)
            .padding(15.dp),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            Modifier
                .fillMaxWidth()
                .align(Alignment.BottomCenter)
                .padding(10.dp),
            verticalArrangement = Arrangement.spacedBy(buttonSpacing)
        ) {
            Text(
                text = "${state.number1}${state.operation?.symbols ?: ""}${state.number2}",
                textAlign = TextAlign.Right,
                modifier = Modifier.fillMaxWidth().padding(vertical = 20.dp),
                fontSize = 36.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 2
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "AC",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Clear)
                    }
                ){}

                CalculatorButton(
                    symbol = "%",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Remainder))
                    }
                ){}

                CalculatorButton(
                    symbol = "Del",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Delete)
                    }
                ){}

                CalculatorButton(
                    symbol = "/",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Division))
                    }
                ){}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "7",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(7))
                    }
                ){}

                CalculatorButton(
                    symbol = "8",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(8))
                    }
                ){}

                CalculatorButton(
                    symbol = "9",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(9))
                    }
                ){}

                CalculatorButton(
                    symbol = "X",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Multiply))
                    }
                ){}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "4",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(4))
                    }
                ){}

                CalculatorButton(
                    symbol = "5",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(5))
                    }
                ){}

                CalculatorButton(
                    symbol = "6",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(6))
                    }
                ){}

                CalculatorButton(
                    symbol = "-",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Subtract))
                    }
                ){}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "1",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(1))
                    }
                ){}

                CalculatorButton(
                    symbol = "2",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(2))
                    }
                ){}

                CalculatorButton(
                    symbol = "3",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(3))
                    }
                ){}

                CalculatorButton(
                    symbol = "+",
                    modifier = Modifier
                        .background(Color.Black)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Operation(CalculatorOperation.Add))
                    }
                ){}
            }

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.spacedBy(buttonSpacing)
            ) {
                CalculatorButton(
                    symbol = "00",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberDoubleZero("00"))
                    }
                ){}

                CalculatorButton(
                    symbol = "0",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.NumberEnter(0))
                    }
                ){}

                CalculatorButton(
                    symbol = ".",
                    modifier = Modifier
                        .background(Color.LightGray)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Decimal)
                    }
                ){}

                CalculatorButton(
                    symbol = "=",
                    modifier = Modifier
                        .background(DarkPink)
                        .aspectRatio(1f)
                        .weight(1f),
                    onclick = {
                        onAction(CalculatorAction.Calculate)
                    }
                ){}
            }
        }
    }
}


//@Preview(showSystemUi = true, showBackground = true)
//@Composable
//fun GreetingPreview2() {
//    CalculatorUI(CalculatorState("25", "10", "+"))
//}