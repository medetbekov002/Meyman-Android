package com.example.meyman.presentation.ui.screens.room_page.tablayout

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.meyman.presentation.ui.screens.room_page.tablayout.childrenAndExtraBeds.ChildrenAndExtraBedsFragment
import com.example.meyman.presentation.ui.screens.room_page.tablayout.conditions.ConditionsFragment
import com.example.meyman.presentation.ui.screens.room_page.tablayout.facilities.FacilitiesFragment
import com.example.meyman.presentation.ui.screens.room_page.tablayout.review.ReviewFragment

class ViewPagerAdapter(fragment: Fragment): FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ConditionsFragment()
            1 -> FacilitiesFragment()
            2 -> ReviewFragment()
            3 -> ChildrenAndExtraBedsFragment()
            else -> ChildrenAndExtraBedsFragment()
        }
    }
}