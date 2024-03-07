package com.tlw.composeCalculator.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.tlw.composeCalculator.data.model.ResultEntity

@Database(entities = [ResultEntity::class], version = 1)
abstract class ResultDB: RoomDatabase() {
    abstract fun resultDao(): Dao
}