package com.example.currencyconverter.data

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.Transformations
import com.example.currencyconverter.data.database.CurrencyDatabase
import com.example.currencyconverter.data.mappers.CurrencyMapper
import com.example.currencyconverter.domain.CurrencyRepository
import com.example.currencyconverter.domain.model.CurrencyModel

class CurrencyRepositoryImpl(context: Context) : CurrencyRepository {


    private val dao = CurrencyDatabase.getInstance(context).getCurrencyDao()

    override fun insertDBData(currencies: List<CurrencyModel>) {
        val entity = currencies.map { CurrencyMapper.toCurrencyEntity(it) }
        dao.insertCurrencyList(entity)
    }

    override fun getDBData(): LiveData<List<CurrencyModel>> =
        Transformations.map(dao.getAllCurrencies()) { list ->
            list.map {
                CurrencyMapper.fromCurrencyEntity(it)
            }
        }

}