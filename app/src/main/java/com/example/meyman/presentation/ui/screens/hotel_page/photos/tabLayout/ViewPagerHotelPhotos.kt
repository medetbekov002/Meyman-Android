package com.example.meyman.presentation.ui.screens.hotel_page.photos.tabLayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.meyman.presentation.ui.screens.hotel_page.photos.allPhotos.HotelAllPhotosFragment
import com.example.meyman.presentation.ui.screens.hotel_page.photos.conference.HotelConferenceFragment
import com.example.meyman.presentation.ui.screens.hotel_page.photos.fitness.HotelFitnessFragment
import com.example.meyman.presentation.ui.screens.hotel_page.photos.restaurant.HotelRestaurantFragment
import com.example.meyman.presentation.ui.screens.hotel_page.photos.rooms.HotelRoomsFragment

class ViewPagerHotelPhotos(fm: Fragment) : FragmentStateAdapter(fm) {

    override fun getItemCount(): Int = 5

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> HotelAllPhotosFragment()
            1 -> HotelRoomsFragment()
            2 -> HotelRestaurantFragment()
            3 -> HotelFitnessFragment()
            4 -> HotelConferenceFragment()
            else -> HotelAllPhotosFragment()
        }
    }
}