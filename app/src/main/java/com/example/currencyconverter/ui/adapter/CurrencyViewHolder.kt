package com.example.currencyconverter.ui.adapter

import androidx.recyclerview.widget.RecyclerView
import com.example.currencyconverter.databinding.ItemCurrencyBinding
import com.example.currencyconverter.domain.model.CurrencyModel

class CurrencyViewHolder(
    private val binding: ItemCurrencyBinding
): RecyclerView.ViewHolder(binding.root) {

    fun bind(currency: CurrencyModel) {
        with(binding) {
            charCode.text = currency.charCode
            currencyName.text = currency.name
            currencyValue.text = String.format("%.2f", (currency.value / currency.nominal))
        }
    }
}