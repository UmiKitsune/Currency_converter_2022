package com.example.currencyconverter.ui

import android.os.Bundle
import android.view.*
import androidx.fragment.app.Fragment
import com.example.currencyconverter.R


class AppInfoFragment : Fragment(R.layout.fragment_app_info) {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        return super.onCreateView(inflater, container, savedInstanceState)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.findItem(R.id.reload).isVisible = false
        super.onCreateOptionsMenu(menu, inflater)
    }
}