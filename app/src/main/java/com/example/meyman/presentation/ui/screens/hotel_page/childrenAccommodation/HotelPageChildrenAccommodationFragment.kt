package com.example.meyman.presentation.ui.screens.hotel_page.childrenAccommodation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.databinding.FragmentHotelPageChildrenAccommodationBinding

class HotelPageChildrenAccommodationFragment : Fragment() {

    private lateinit var binding: FragmentHotelPageChildrenAccommodationBinding
    private val viewModel: HotelPageChildrenAccommodationViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelPageChildrenAccommodationBinding.inflate(inflater, container, false)
        return binding.root
    }

}