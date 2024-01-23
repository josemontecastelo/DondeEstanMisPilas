package com.josealfonsomora.dondeestanmispilas.di

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import com.josealfonsomora.dondeestanmispilas.bd.PilasDBHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.qualifiers.ApplicationContext

@Module
@InstallIn(ViewModelComponent::class)
object PilasDbModule{

    @Provides
    fun providesPilasDbHelper(@ApplicationContext context: Context): SQLiteDatabase {
        return PilasDBHelper(context).writableDatabase
    }
}