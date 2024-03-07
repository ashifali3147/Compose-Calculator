package com.tlw.composeCalculator.di
import android.app.Application
import androidx.room.Room
import com.tlw.composeCalculator.data.db.ResultDB
import com.tlw.composeCalculator.data.repository.ResultRepository
import com.tlw.composeCalculator.data.repository.ResultRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object CalculatorModule {
    @Provides
    @Singleton
    fun provideResultDB(app: Application): ResultDB {
        return Room.databaseBuilder(app, ResultDB::class.java, "calculation_result_db").build()
    }
    @Provides
    @Singleton
    fun provideResultRepository(db: ResultDB): ResultRepository {
        return ResultRepositoryImpl(db.resultDao())
    }
}