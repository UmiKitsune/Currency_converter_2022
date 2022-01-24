package com.example.currencyconverter.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.currencyconverter.R
import com.example.currencyconverter.databinding.FragmentCurrencyListBinding
import com.example.currencyconverter.presentation.CurrencyListViewModel
import com.example.currencyconverter.presentation.ViewModelFactory
import com.example.currencyconverter.ui.adapter.CurrencyAdapter
import com.example.currencyconverter.ui.states.MyState

class CurrencyListFragment : Fragment() {

    lateinit var binding: FragmentCurrencyListBinding
    private lateinit var currencyAdapter: CurrencyAdapter
    private val viewModel: CurrencyListViewModel by viewModels{ViewModelFactory(requireContext())}

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        setHasOptionsMenu(true)
        binding = FragmentCurrencyListBinding.inflate(inflater, container, false)
        currencyAdapter = CurrencyAdapter()

        viewModel.dbData.observe(viewLifecycleOwner, {
            if (it.isEmpty()) {
                viewModel.loadData()
            } else {
                currencyAdapter.currencies = it
            }
        })
        viewModel.startTimer()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.state.observe(viewLifecycleOwner, ::checkState)

        viewModel.data.observe(viewLifecycleOwner, {
            currencyAdapter.currencies = it
        })
        binding.recyclerView.adapter = currencyAdapter
    }

    private fun checkState(state: MyState) {
        when(state) {
            is  MyState.Loading -> { binding.apply {
                recyclerView.visibility = View.GONE
                progressBar.visibility - View.VISIBLE

            } }
            is  MyState.Success -> { binding.apply {
                recyclerView.visibility = View.VISIBLE
                progressBar.visibility - View.GONE
            } }
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.reload -> {
                viewModel.loadData()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}