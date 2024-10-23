package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.databinding.FragmentReviewBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ReviewFragment : Fragment() {

        private lateinit var binding: FragmentReviewBinding
        private val viewModel: ReviewViewModel by viewModels()
        private val reviewAdapter = ReviewAdapter()

        override fun onCreateView(
            inflater: LayoutInflater,
            container: ViewGroup?,
            savedInstanceState: Bundle?
        ): View {
            binding = FragmentReviewBinding.inflate(inflater, container, false)
            return binding.root
        }

        override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
            super.onViewCreated(view, savedInstanceState)
            initialize()
            setupSubscribes()
        }

        private fun initialize() {
            binding.rvReview.adapter = reviewAdapter
        }

        private fun setupSubscribes() {
        }
    }