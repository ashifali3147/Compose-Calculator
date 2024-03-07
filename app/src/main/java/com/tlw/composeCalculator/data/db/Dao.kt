package com.tlw.composeCalculator.data.db

import androidx.compose.runtime.MutableState
import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.tlw.composeCalculator.data.model.ResultEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface Dao {
    @Upsert
    suspend fun addResult(result: ResultEntity)
    @Delete
    suspend fun deleteResult(result: ResultEntity)
    @Query("SELECT * FROM resultentity")
    fun getResult(): Flow<MutableList<ResultEntity>>
}