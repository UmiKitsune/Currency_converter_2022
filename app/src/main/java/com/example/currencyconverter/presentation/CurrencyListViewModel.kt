package com.example.currencyconverter.presentation

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.currencyconverter.data.json.api.ApiFactory
import com.example.currencyconverter.domain.model.CurrencyModel
import com.example.currencyconverter.domain.usecase.GetDataFromDbUseCase
import com.example.currencyconverter.domain.usecase.SaveDataToDBUseCase
import com.example.currencyconverter.ui.states.MyState
import io.reactivex.Observable
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.concurrent.TimeUnit

class CurrencyListViewModel(
    dataFromDatabase: GetDataFromDbUseCase,
    private val saveDataToDatabase: SaveDataToDBUseCase
): ViewModel() {

    private var _data = MutableLiveData<List<CurrencyModel>>()
    val data: LiveData<List<CurrencyModel>> = _data

    private var _dbData: LiveData<List<CurrencyModel>> = dataFromDatabase()
    val dbData: LiveData<List<CurrencyModel>> = _dbData

    private var _state: MutableLiveData<MyState> = MutableLiveData()
    val state: LiveData<MyState> = _state

    private val compositeDisposable = CompositeDisposable()

    fun loadData() {
        _state.value = MyState.Loading
        val disposable = ApiFactory.apiCurrency.getCurrencies()
            .map {it.charCodes.values}
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                _data.value = it.toList()
                insertDataToDB()
                _state.value = MyState.Success
            },
                {
                    println("some error!")
                })
        compositeDisposable.add(disposable)
    }

    private fun insertDataToDB() {
        val dis = ApiFactory.apiCurrency.getCurrencies()
            .map { it.charCodes.values }
            .subscribeOn(Schedulers.io())
            .subscribe({
                saveDataToDatabase(it.toList())
            },{
                println("some error!")
            })
        compositeDisposable.add(dis)
    }

    fun startTimer() {
        val disp = Observable.interval(20,TimeUnit.SECONDS)
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({
                  loadData()
            }, {
                println("some timer error")
            })
        compositeDisposable.add(disp)
    }


    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}