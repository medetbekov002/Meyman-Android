package com.example.meyman.presentation.ui.screens.onboard

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.core.view.isGone
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import androidx.navigation.fragment.findNavController
import androidx.viewpager2.widget.ViewPager2
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentOnBoardBinding
import com.example.meyman.presentation.ui.adapter.OnBoardViewPagerAdapter
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class OnBoardFragment : Fragment() {

    @Inject
    lateinit var userDataPreferencesHelper: UserDataPreferencesHelper
    private lateinit var binding: FragmentOnBoardBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
    }

    private fun initialize() = with(binding){
        viewPager.adapter = OnBoardViewPagerAdapter(this@OnBoardFragment)
        dotsIndicator.attachTo(viewPager)
        roundButton.setOnClickListener {
            viewPager.currentItem = viewPager.currentItem + nextAction
        }
        startButton.setOnClickListener {
           findNavController().navigate(R.id.homeFragment)
        }
        userDataPreferencesHelper.apply {
            saveOnBoard = true
        }
    }

    private fun setupListener() {
        binding.viewPager.registerOnPageChangeCallback(object : ViewPager2.OnPageChangeCallback() {
            override fun onPageSelected(position: Int) {
                when (position) {
                    0 -> {
                        binding.roundButton.isGone = false
                        binding.startButton.isGone = true
                    }
                    1 -> {
                        binding.roundButton.isGone = false
                        binding.startButton.isGone = true
                    }
                    2 -> {
                        binding.roundButton.visibility = View.INVISIBLE
                        binding.startButton.isGone = false
                    }
                }
                super.onPageSelected(position)
            }
        })
    }

    companion object {
        const val nextAction = 1
    }
}