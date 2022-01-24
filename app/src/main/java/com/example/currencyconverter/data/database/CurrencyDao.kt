package com.example.currencyconverter.data.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CurrencyDao {

    @Query("SELECT * FROM currencies")
    fun getAllCurrencies(): LiveData<List<CurrencyEntity>>

    @Query("SELECT * FROM currencies WHERE charCode = :charCode")
    fun getCurrencyByCharCode(charCode: String): CurrencyEntity

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertCurrencyList(currencyList: List<CurrencyEntity>)
}