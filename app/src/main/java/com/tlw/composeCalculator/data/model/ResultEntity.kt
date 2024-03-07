package com.tlw.composeCalculator.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class ResultEntity(
    val number1: String = "",
    val number2: String = "",
    val operation: String = "",
    val result: String = "",
    @PrimaryKey
    val id: Int? = null
)
