package com.example.currencyconverter.ui.states

 sealed class MyState {
     object Loading: MyState()

     object Success: MyState()
}