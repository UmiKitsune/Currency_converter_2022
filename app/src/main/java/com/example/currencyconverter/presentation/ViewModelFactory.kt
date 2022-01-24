package com.example.currencyconverter.presentation

import android.content.Context
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.currencyconverter.data.CurrencyRepositoryImpl
import com.example.currencyconverter.domain.usecase.GetDataFromDbUseCase
import com.example.currencyconverter.domain.usecase.SaveDataToDBUseCase

class ViewModelFactory(
    context: Context
): ViewModelProvider.Factory {

    private val repository = CurrencyRepositoryImpl(context)

    private val saveDataUseCase = SaveDataToDBUseCase(repository)
    private val getAllDataUseCase = GetDataFromDbUseCase(repository)

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        val viewModel = when(modelClass) {
            CurrencyListViewModel::class.java -> {
                CurrencyListViewModel(getAllDataUseCase, saveDataUseCase)
            }
            CurrencyConverterViewModel::class.java -> {
                CurrencyConverterViewModel(getAllDataUseCase)
            }
            else -> {
                throw IllegalStateException("Unknown view model class")
            }
        }
        return viewModel as T
    }
}