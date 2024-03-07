package com.tlw.composeCalculator.data.repository

import androidx.compose.runtime.MutableState
import androidx.room.Delete
import androidx.room.Query
import com.tlw.composeCalculator.data.model.ResultEntity
import kotlinx.coroutines.flow.Flow

interface ResultRepository {
    suspend fun addResult(result: ResultEntity)

    suspend fun deleteResult(result: ResultEntity)

    fun getResult(): Flow<MutableList<ResultEntity>>
}