package com.example.meyman.presentation.ui.screens.room_page.tablayout.conditions

import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentConditionsBinding
import com.example.meyman.presentation.ui.screens.room_page.tablayout.ViewPagerAdapter
import com.google.android.material.tabs.TabLayoutMediator

class ConditionsFragment : BaseFragment<FragmentConditionsBinding, ConditionsViewModel>(R.layout.fragment_conditions) {

    override val binding by viewBinding(FragmentConditionsBinding::bind)
    override val viewModel: ConditionsViewModel by viewModels()

    override fun initialize() {
        super.initialize()
    }
}