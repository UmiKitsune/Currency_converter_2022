package com.example.currencyconverter.domain.model

import com.google.gson.annotations.SerializedName

data class FullJSON(
    @SerializedName("Valute")
    val charCodes: Map<String, CurrencyModel>
)