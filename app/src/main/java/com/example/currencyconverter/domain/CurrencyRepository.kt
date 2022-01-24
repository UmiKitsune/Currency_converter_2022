package com.example.currencyconverter.domain

import androidx.lifecycle.LiveData
import com.example.currencyconverter.domain.model.CurrencyModel

interface CurrencyRepository {

    fun insertDBData(currencies: List<CurrencyModel>)

    fun getDBData(): LiveData<List<CurrencyModel>>

}