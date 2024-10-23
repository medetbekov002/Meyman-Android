package com.example.meyman.presentation.ui.adapter

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.meyman.presentation.ui.screens.onboard.OnBoardPagingFragment

class OnBoardViewPagerAdapter(fragment: Fragment) : FragmentStateAdapter(fragment){

    override fun getItemCount(): Int = 3

    override fun createFragment(position: Int) = OnBoardPagingFragment().apply {
        arguments = Bundle().apply {
            putInt(OnBoardPagingFragment.ARG_ONBOARD_PAGE_POSITION   , position)
        }
    }
}