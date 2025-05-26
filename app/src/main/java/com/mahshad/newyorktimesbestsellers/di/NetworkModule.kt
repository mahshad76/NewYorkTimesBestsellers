package com.mahshad.newyorktimesbestsellers.di

import com.mahshad.newyorktimesbestsellers.data.network.ApiService
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@Singleton
object NetworkModule {
    @Singleton
    @Provides
    fun provideOkHttpLoggingInterceptor(): HttpLoggingInterceptor =
        HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)

    @Singleton
    @Provides
    fun okHttpClient(loggingInterceptor: HttpLoggingInterceptor) =
        OkHttpClient.Builder().apply {
            addInterceptor(loggingInterceptor)
            connectTimeout(30L, TimeUnit.SECONDS)
            readTimeout(30L, TimeUnit.SECONDS)
            writeTimeout(30L, TimeUnit.SECONDS)
            followRedirects(true)
            followSslRedirects(true)
        }.build()

    @Singleton
    @Provides
    fun provideRetrofit(okhttpClient: OkHttpClient) = lazy {
        Retrofit.Builder().apply {
            addConverterFactory(GsonConverterFactory.create())
            baseUrl("http://api.nytimes.com/")
            client(okhttpClient)
        }
            .build()
    }

    @Singleton
    @Provides
    fun provideApiService(retrofit: Retrofit) = retrofit.create(ApiService::class.java)

}