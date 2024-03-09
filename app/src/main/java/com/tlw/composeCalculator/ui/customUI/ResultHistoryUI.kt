@file:OptIn(ExperimentalMaterial3Api::class)

package com.tlw.composeCalculator.ui.customUI

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeOut
import androidx.compose.animation.shrinkVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.DismissDirection
import androidx.compose.material3.DismissState
import androidx.compose.material3.DismissValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.SwipeToDismiss
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDismissState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.tlw.composeCalculator.data.model.ResultEntity
import com.tlw.composeCalculator.ui.theme.CalculatorTheme
import com.tlw.composeCalculator.ui.viewmodel.ResultHistoryViewModel
import kotlinx.coroutines.delay

@Composable
fun ResultHistoryUI(resultState: State<List<ResultEntity>>, viewModel: ResultHistoryViewModel) {
    val result = resultState.value

    Row(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        if (result.isNotEmpty()) {
            LazyColumn {
                items(result) { item ->

                    SwipeToDeleteContainer(item = item, onDelete ={
                        viewModel.deleteResult(it)
                    } ) {
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
                                modifier = Modifier.fillMaxWidth(),
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
}


@Composable
fun <T>SwipeToDeleteContainer(
    item: T,
    onDelete: (T) -> Unit,
    animationDuration: Int = 500,
    content: @Composable (T) -> Unit
) {

    var isRemoved by remember {
        mutableStateOf(false)
    }
    val state = rememberDismissState(
        confirmValueChange = { value ->
            if (value == DismissValue.DismissedToStart){
                isRemoved = true
                true
            } else{
                false
            }
        }
    )
    
    LaunchedEffect(key1 = isRemoved){
        if (isRemoved){
            delay(animationDuration.toLong())
            onDelete(item)
        }
    }
    AnimatedVisibility(visible = !isRemoved,
        exit = shrinkVertically(
            animationSpec = tween(durationMillis = animationDuration), shrinkTowards = Alignment.Top
        ) + fadeOut()
    ) {
        SwipeToDismiss(state = state, background ={
            DeleteBackground(swipeToDismissState = state)
        } , dismissContent = {content(item)},
            directions = setOf(DismissDirection.EndToStart)
        )
    }
}
@Composable
fun DeleteBackground(swipeToDismissState: DismissState) {
    val color =
        if (swipeToDismissState.dismissDirection == DismissDirection.EndToStart) Color.Red else Color.Transparent
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(color)
            .padding(16.dp),
        contentAlignment = Alignment.CenterEnd
    ) {
        Icon(imageVector = Icons.Default.Delete, contentDescription = null, tint = Color.White)
    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
fun GreetingPreview4() {
    CalculatorTheme {
//        ResultHistoryUI(mutableListOf())
    }
}