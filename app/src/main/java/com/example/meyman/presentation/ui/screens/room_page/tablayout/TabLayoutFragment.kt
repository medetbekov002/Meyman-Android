package com.example.meyman.presentation.ui.screens.room_page.tablayout

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.databinding.FragmentTabLayoutBinding

class TabLayoutFragment : Fragment(R.layout.fragment_tab_layout) {

    private val binding by viewBinding(FragmentTabLayoutBinding::bind)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
       initialize()
    }

    private fun initialize() {

    }
}