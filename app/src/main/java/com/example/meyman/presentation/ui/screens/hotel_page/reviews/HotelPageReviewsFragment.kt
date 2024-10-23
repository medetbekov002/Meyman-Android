package com.example.meyman.presentation.ui.screens.hotel_page.reviews

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.meyman.R
import com.example.meyman.databinding.FragmentHotelPageReviewsBinding

class HotelPageReviewsFragment : Fragment() {

    private lateinit var binding: FragmentHotelPageReviewsBinding
    private val viewModel: HotelPageReviewsViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHotelPageReviewsBinding.inflate(inflater, container, false)
        return binding.root
    }
}