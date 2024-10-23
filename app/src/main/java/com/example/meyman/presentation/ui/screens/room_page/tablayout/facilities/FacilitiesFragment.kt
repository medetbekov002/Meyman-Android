package com.example.meyman.presentation.ui.screens.room_page.tablayout.facilities

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class FacilitiesFragment : Fragment() {

    companion object {
        fun newInstance() = FacilitiesFragment()
    }

    private lateinit var viewModel: FacilitiesViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_facilities, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(FacilitiesViewModel::class.java)
        // TODO: Use the ViewModel
    }

}