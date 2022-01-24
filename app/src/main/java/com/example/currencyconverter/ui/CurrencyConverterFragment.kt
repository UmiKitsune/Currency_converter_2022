package com.example.currencyconverter.ui

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentCurrencyConverterBinding
import com.example.currencyconverter.domain.model.CurrencyModel
import com.example.currencyconverter.presentation.CurrencyConverterViewModel
import com.example.currencyconverter.presentation.ViewModelFactory

class CurrencyConverterFragment : Fragment() {

    lateinit var binding: FragmentCurrencyConverterBinding
    private val viewModel: CurrencyConverterViewModel by viewModels{ ViewModelFactory(requireContext()) }
    private var currencyName: ArrayList<String> = ArrayList()
    private var currencies: List<CurrencyModel> = emptyList()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentCurrencyConverterBinding.inflate(inflater, container, false)

        viewModel.dbData.observe(viewLifecycleOwner, {
            currencies = it
            for (currency in it) {
                currencyName.add(currency.name)
            }
            val spinnerAdapter: ArrayAdapter<String> = ArrayAdapter(requireActivity(), android.R.layout.simple_spinner_item, currencyName)
            binding.converterSpinner.adapter = spinnerAdapter
        })

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.converterButton.setOnClickListener { buttonExchangeOnClick() }

    }

    private fun buttonExchangeOnClick() {
        val rubles = binding.converterEditText.text.toString().trim()
        val spinnerCurrency = binding.converterSpinner.selectedItem.toString()
        var value: Double = 0.0
        var nominal: Int = 0
        var result: Double = 0.0

        for (currency in currencies) {
            if (spinnerCurrency == currency.name){
                value = currency.value
                nominal = currency.nominal
            }
        }

        if (rubles.isEmpty()) {
            Toast.makeText(requireContext(), getString(R.string.empty_rub_txt), Toast.LENGTH_SHORT).show()
        } else {
            val rub = rubles.toDouble()
            val cur =  value / nominal
            result =  rub / cur
            binding.converterResult.text = String.format("%.2f", result)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.reload).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }
}