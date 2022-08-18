package com.example.myapplication.util

import com.example.myapplication.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.concurrent.TimeUnit


object APIClient {
    const val URL : String = "http://192.168.1.31:3000/api/v1/"
    val interceptor = HttpLoggingInterceptor()
    fun initInterceptor() {
        if (BuildConfig.DEBUG) {
            interceptor.level=HttpLoggingInterceptor.Level.BODY;
        } else {
            interceptor.level=HttpLoggingInterceptor.Level.NONE;
        }
    }

    val httpClient = OkHttpClient.Builder()
        .connectTimeout(60, TimeUnit.SECONDS)
        .writeTimeout(60, TimeUnit.SECONDS)
        .readTimeout(60, TimeUnit.SECONDS)
        .addInterceptor(interceptor)
        .addInterceptor { chain ->
            val request: Request =
                chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("User-Agent", "Android")
                    .addHeader("Authorization", "Bearer " + UserToken.getUserToken())
                    .build()
            chain.proceed(request)
        }
        .build()
    val retrofit = Retrofit.Builder()
        .baseUrl(URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .client(httpClient)
        .build()
}