package com.example.meyman.presentation.ui.screens.onboard

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R
import com.example.meyman.databinding.FragmentOnBoardBinding
import com.example.meyman.databinding.FragmentOnBoardPagingBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class OnBoardPagingFragment : Fragment() {

    private lateinit var binding: FragmentOnBoardPagingBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentOnBoardPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
    }

    @SuppressLint("SetTextI18n")
    private fun initialize() = with(binding) {
        when (requireArguments().getInt(ARG_ONBOARD_PAGE_POSITION)) {
            0 -> {
                this.imgPage.setImageResource(R.drawable.hous_order)
                firstTv.text = "Бронируйте лучшие места"
                tvSecond.text = "надёжные отели, апартаменты по выгодной цене"
            }
            1 -> {
                this.imgPage.setImageResource(R.drawable.hous_order2)
                firstTv.text = "Арендуйте комфортное авто "
                tvSecond.text = "и посетите интересные места"
            }
            2 -> {
                this.imgPage.setImageResource(R.drawable.hous_order3)
                firstTv.text = "Наслаждайтесь отдыхом!"
                tvSecond.text = "Планируйте ваши поездки вместе с Meyman"
            }
        }
    }

    companion object {
        const val ARG_ONBOARD_PAGE_POSITION = "OnBoardPage"
    }
}