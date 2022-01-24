package com.example.currencyconverter.data.mappers


import com.example.currencyconverter.data.database.CurrencyEntity
import com.example.currencyconverter.domain.model.CurrencyModel

object CurrencyMapper {

    fun toCurrencyEntity(model: CurrencyModel): CurrencyEntity =
        CurrencyEntity(model.charCode, model.name, model.nominal, model.value)

    fun fromCurrencyEntity(entity: CurrencyEntity): CurrencyModel =
        CurrencyModel(entity.charCode, entity.name, entity.nominal, entity.value)
}