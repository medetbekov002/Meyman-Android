package com.example.meyman.presentation.ui.screens.hotel_page

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.SnapHelper
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentHotelPageBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.hotel_page.tabLayout.HotelPageViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class HotelPageFragment :
    BaseFragment<FragmentHotelPageBinding, HotelPageViewModel>(R.layout.fragment_hotel_page) {

    @Inject
    lateinit var userDataPreferencesHelper: UserDataPreferencesHelper
    override val binding by viewBinding(FragmentHotelPageBinding::bind)
    override val viewModel: HotelPageViewModel by viewModels()
    private lateinit var photoAdapter: HotelPagePhotoAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.viewPager.adapter = HotelPageViewPagerAdapter(this@HotelPageFragment)
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, pos ->
            when (pos) {
                0 -> {
                    tab.text = "Условия"
                }

                1 -> {
                    tab.text = "Удобства"
                }

                2 -> {
                    tab.text = "Здоровье и гигиена"
                }

                3 -> {
                    tab.text = "Отзывы"
                }

                4 -> {
                    tab.text = "Размещение детей"
                }
            }
        }.attach()

        val id = arguments?.getInt("id")

        callApi(id)
        initListener()
    }

    private fun initListener() {
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }

        binding.btnRooms.setOnClickListener {  }
    }

    private fun callApi(id: Int?) {
        viewModel.getHotelById(id!!)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.hotelValue.collect {
                    Log.e("ololo", "HotelPageFragment: ${it}", )
                    when(it){
                        is UIState.Error ->{
                            Log.e("ololo", "callHotelApi-error: ${it.error}", )
                        }

                        is UIState.Loading -> {}
                        is UIState.Success -> {
                            val success = it.data.id
                            val bundle = Bundle()
                            bundle.putInt("id", success)
                            Log.e("ololo", "callHotelApi-success: ${it.data.id}")
                            with(binding) {
                                userDataPreferencesHelper.adress = it.data.address
                                userDataPreferencesHelper.housingName = it.data.housingName
                                tvTitle.text = it.data.address
                                tvRatingScore.text = it.data.stars.toString()
                              tvHotelName.text = it.data.housingName
                                photoAdapter = HotelPagePhotoAdapter()
                                binding.rvPhoto.adapter = photoAdapter
                                val snapHelper: SnapHelper = PagerSnapHelper()
                                snapHelper.attachToRecyclerView(binding.rvPhoto)
                                it.data.housingImages?.let { photoAdapter.submitList(it) }
                                binding.btnRooms.setOnClickListener {
                                    findNavController().navigate(R.id.action_hotelPageFragment_to_roomsFragment, bundle)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}