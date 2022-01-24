package com.example.currencyconverter.data.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "currencies")
data class CurrencyEntity(
    @PrimaryKey
    val charCode: String,
    val name: String,
    val nominal: Int,
    val value: Double
)