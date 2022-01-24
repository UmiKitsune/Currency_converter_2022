package com.example.currencyconverter.data.json.api

import com.example.currencyconverter.BuildConfig
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiFactory {

    private const val BASE_URL = "https://www.cbr-xml-daily.ru/"

    private val retrofit =
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(
                OkHttpClient.Builder().also { client ->
                    if (BuildConfig.DEBUG) {
                        val log = HttpLoggingInterceptor()
                        log.setLevel(HttpLoggingInterceptor.Level.BODY)
                        client.addInterceptor(log)
                    }
                }.build()
            )
            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val apiCurrency: ApiCurrency = retrofit.create(ApiCurrency::class.java)
}
