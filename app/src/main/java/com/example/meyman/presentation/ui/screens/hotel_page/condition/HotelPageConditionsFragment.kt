package com.example.meyman.presentation.ui.screens.hotel_page.condition

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.databinding.FragmentHotelPageConditionsBinding

class HotelPageConditionsFragment : Fragment() {

    private lateinit var binding: FragmentHotelPageConditionsBinding
    private val viewModel: HotelPageConditionsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelPageConditionsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

}