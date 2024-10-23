package com.example.meyman.presentation.ui.screens.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentHomeBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.dashboard.DashboardFragment
import com.example.meyman.presentation.ui.screens.home.adapter.AdvertisingAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {

    @Inject
     lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentHomeBinding
    private val viewModel: HomeViewModel by viewModels()
    private val adapter = AdvertisingAdapter()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
     binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()

        binding.tvOptions2.text = "${userPreferencesData.adults} взрослых"
        binding.tvOptions3.text = "${userPreferencesData.children} детей"

        binding.mcvOptions.setOnClickListener {
            val bottomSheetFragment = DashboardFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
        }

        binding.btnSearch.setOnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_searchResultsFragment)
        }
    }

    private fun initialize() {
        binding.rvRecomend.adapter = adapter
    }

    private fun setupSubscribes() {
        subscribeToFetchAdvertising()
    }

    private fun subscribeToFetchAdvertising() {
            viewModel.getAdvertising()
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                    viewModel.advertisingState.collect {
                        when (it) {
                            is UIState.Error -> {
                            }

                            is UIState.Loading -> {
                            }

                        is UIState.Success -> {
                            Toast.makeText(requireContext(), "ABOBA", Toast.LENGTH_SHORT).show()
                            adapter.submitList(it.data)
                        }
                        else -> {}
                    }
                }
            }
        }
    }
}