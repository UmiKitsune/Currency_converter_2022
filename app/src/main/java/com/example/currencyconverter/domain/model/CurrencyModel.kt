package com.example.currencyconverter.domain.model

import com.google.gson.annotations.SerializedName


data class CurrencyModel(
    @SerializedName("CharCode")
    val charCode: String,

    @SerializedName("Name")
    val name: String,

    @SerializedName("Nominal")
    val nominal: Int,

    @SerializedName("Value")
    val value: Double
)