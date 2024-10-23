package com.example.meyman.presentation.ui.screens.hotel_page.reviewAdd

import android.text.Editable
import android.text.TextWatcher
import android.widget.SeekBar
import android.widget.Toast
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentReviewAddBinding

class ReviewAddFragment :
    BaseFragment<FragmentReviewAddBinding, ReviewAddViewModel>(R.layout.fragment_review_add) {

    override val binding by viewBinding(FragmentReviewAddBinding::bind)
    override val viewModel: ReviewAddViewModel by viewModels()


    override fun initialize() {
        seekBarRating()
    }

    private fun seekBarRating() {
        binding.sbAllRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                // Обработка изменения значения seekBar
                val selectedValue = progress + 1
                // Пример вывода значения в консоль
                binding.tvAllRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
                // Вызывается при начале перемещения ползунка
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
                // Вызывается при окончании перемещения ползунка
            }
        })
        binding.sbStaffRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvStaffRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        binding.sbComfortRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvComfortRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        binding.sbCleanlinessRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvCleanlinessRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        binding.sbPriceQualityRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvPriceQualityRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        binding.sbFoodRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvFoodRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
        binding.sbLocationRating.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar, progress: Int, fromUser: Boolean) {
                val selectedValue = progress + 1
                binding.tvLocationRating.text = selectedValue.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar) {
            }
        })
    }

    override fun setupSubscribes() {

        binding.etReviewDescription.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                // Ничего не делаем перед изменением текста
            }
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                // Обновляем TextView с количеством символов
                val charCount = s?.length ?: 0
                binding.tvDescriptionCount.text = "$charCount/500"
                if (charCount == 10){
                    Toast.makeText(requireContext(), "dfas", Toast.LENGTH_SHORT).show()
                }
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })
    }
}

