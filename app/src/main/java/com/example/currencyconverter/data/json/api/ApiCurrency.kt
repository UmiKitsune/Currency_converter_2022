package com.example.currencyconverter.data.json.api

import com.example.currencyconverter.domain.model.FullJSON
import io.reactivex.Single
import retrofit2.http.GET

interface ApiCurrency {

    @GET("daily_json.js")
    fun getCurrencies() : Single<FullJSON>
}