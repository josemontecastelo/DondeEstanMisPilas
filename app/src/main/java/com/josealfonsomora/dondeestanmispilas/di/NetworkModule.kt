package com.josealfonsomora.dondeestanmispilas.di

import com.josealfonsomora.dondeestanmispilas.api.CatsApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(ViewModelComponent::class)
object NetworkModule{
    @Provides
    fun providesLoggerInterceptor(): HttpLoggingInterceptor {
        val loggingInterceptor = HttpLoggingInterceptor()
        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY)
        return loggingInterceptor
    }
    @Provides
    fun providesOkhttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    fun providesCatsService(client: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://cat-fact.herokuapp.com")
//            .addConverterFactory(Json.asConverterFactory("application/json".toMediaType()))
            .addConverterFactory(GsonConverterFactory.create())
            .client(client)
            .build()
    }


    @Provides
    fun providesCatApi(retrofit: Retrofit)  = retrofit.create(CatsApi::class.java)

}