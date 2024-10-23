package com.example.meyman.presentation.ui.screens.hotel_page.health_and_hygiene

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.databinding.FragmentHotelPageHealthAndHygieneBinding

class HotelPageHealthAndHygieneFragment : Fragment() {

    private lateinit var binding: FragmentHotelPageHealthAndHygieneBinding
    private val viewModel: HotelPageHealthAndHygieneViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelPageHealthAndHygieneBinding.inflate(inflater, container, false)
        return binding.root
    }

}