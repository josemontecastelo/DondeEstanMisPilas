package com.josealfonsomora.dondeestanmispilas.di

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStore
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class PilasDataStore

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class UserDataStore

@Module
@InstallIn(SingletonComponent::class)
object SharePreferencesModule {
    // At the top level of your kotlin file:
    private val Context.dataStore: DataStore<Preferences> by preferencesDataStore(name = "pilas")
    private val Context.userdataStore: DataStore<Preferences> by preferencesDataStore(name = "user")

    @Provides
    @PilasDataStore
    fun providesPilasDataStore(@ApplicationContext context: Context):DataStore<Preferences> = context.dataStore

    @Provides
    @UserDataStore
    fun providesUserDataStore(@ApplicationContext context: Context):DataStore<Preferences> = context.userdataStore
}