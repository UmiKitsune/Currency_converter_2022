package com.example.currencyconverter.domain.usecase

import com.example.currencyconverter.domain.CurrencyRepository
import com.example.currencyconverter.domain.model.CurrencyModel

class SaveDataToDBUseCase(private val repository: CurrencyRepository) {
    operator fun invoke(currencies: List<CurrencyModel>) =
        repository.insertDBData(currencies)
}