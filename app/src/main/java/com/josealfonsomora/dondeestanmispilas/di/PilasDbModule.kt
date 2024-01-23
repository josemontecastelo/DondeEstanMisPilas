package com.josealfonsomora.dondeestanmispilas.di

import android.content.Context
import androidx.room.Room
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.PilasDBRoom
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object PilasDbModule {
    const val DATABASE_NAME = "PilasRoom.db"

    @Provides
    fun providesPilasDbRoom(@ApplicationContext context: Context) = Room.databaseBuilder(
        context,
        PilasDBRoom::class.java, DATABASE_NAME
    ).build()

    @Provides
    fun providesPilaDao(pilasDBRoom: PilasDBRoom) = pilasDBRoom.pilaDao()
}