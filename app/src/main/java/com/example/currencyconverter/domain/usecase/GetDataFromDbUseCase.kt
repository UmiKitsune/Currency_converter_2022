package com.example.currencyconverter.domain.usecase

import androidx.lifecycle.LiveData
import com.example.currencyconverter.domain.CurrencyRepository
import com.example.currencyconverter.domain.model.CurrencyModel

class GetDataFromDbUseCase(private val repository: CurrencyRepository) {
    operator fun invoke(): LiveData<List<CurrencyModel>> =
        repository.getDBData()

}