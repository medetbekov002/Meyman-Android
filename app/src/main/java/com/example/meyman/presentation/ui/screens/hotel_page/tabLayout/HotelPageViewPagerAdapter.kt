package com.example.meyman.presentation.ui.screens.hotel_page.tabLayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.meyman.presentation.ui.screens.hotel_page.childrenAccommodation.HotelPageChildrenAccommodationFragment
import com.example.meyman.presentation.ui.screens.hotel_page.condition.HotelPageConditionsFragment
import com.example.meyman.presentation.ui.screens.hotel_page.facilities.HotelPageFacilitiesFragment
import com.example.meyman.presentation.ui.screens.hotel_page.health_and_hygiene.HotelPageHealthAndHygieneFragment
import com.example.meyman.presentation.ui.screens.hotel_page.reviews.HotelPageReviewsFragment

class HotelPageViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HotelPageConditionsFragment()
            1 -> HotelPageFacilitiesFragment()
            2 -> HotelPageHealthAndHygieneFragment()
            3 -> HotelPageReviewsFragment()
            4 -> HotelPageChildrenAccommodationFragment()
            else -> HotelPageConditionsFragment()
        }
    }
}