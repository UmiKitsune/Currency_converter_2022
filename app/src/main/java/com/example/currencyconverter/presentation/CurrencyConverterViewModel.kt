package com.example.currencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.domain.model.CurrencyModel
import com.example.currencyconverter.domain.usecase.GetDataFromDbUseCase

class CurrencyConverterViewModel(
    dataFromDatabase: GetDataFromDbUseCase,
): ViewModel() {

    private var _dbData: LiveData<List<CurrencyModel>> = dataFromDatabase()
    val dbData: LiveData<List<CurrencyModel>> = _dbData

}