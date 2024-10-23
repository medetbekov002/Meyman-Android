package com.example.meyman.presentation.ui.screens.hotel_page.photos

import android.os.Bundle
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentHotelPhotosBinding
import com.example.meyman.presentation.ui.screens.hotel_page.photos.tabLayout.ViewPagerHotelPhotos
import com.google.android.material.tabs.TabLayoutMediator

class HotelPhotosFragment :
    BaseFragment<FragmentHotelPhotosBinding, HotelPhotosViewModel>(R.layout.fragment_hotel_photos) {

    override val binding by viewBinding(FragmentHotelPhotosBinding::bind)
    override val viewModel: HotelPhotosViewModel by viewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = ViewPagerHotelPhotos(this@HotelPhotosFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Все фото"
                }

                1 -> {
                    tab.text = "Номера"
                }

                2 -> {
                    tab.text = "Ресторан"
                }

                3 -> {
                    tab.text = "Фитнес центр"
                }

                4 -> {
                    tab.text = "Конференц-зал"
                }
            }
        }.attach()
    }


}