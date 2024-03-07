package com.tlw.composeCalculator.data.repository

import androidx.compose.runtime.MutableState
import com.tlw.composeCalculator.data.db.Dao
import com.tlw.composeCalculator.data.model.ResultEntity
import kotlinx.coroutines.flow.Flow

class ResultRepositoryImpl(private val dao: Dao): ResultRepository {
    override suspend fun addResult(result: ResultEntity) {
        dao.addResult(result)
    }

    override suspend fun deleteResult(result: ResultEntity) {
        dao.deleteResult(result)
    }

    override fun getResult(): Flow<MutableList<ResultEntity>> {
        return dao.getResult()
    }
}