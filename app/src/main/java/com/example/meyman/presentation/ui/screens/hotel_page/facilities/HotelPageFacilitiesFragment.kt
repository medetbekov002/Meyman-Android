package com.example.meyman.presentation.ui.screens.hotel_page.facilities

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.R
import com.example.meyman.databinding.FragmentHotelPageFacilitiesBinding

class HotelPageFacilitiesFragment : Fragment() {

    private lateinit var binding: FragmentHotelPageFacilitiesBinding
    private val viewModel: HotelPageFacilitiesViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelPageFacilitiesBinding.inflate(inflater, container,false)
        return binding.root
    }

}