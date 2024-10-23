package com.example.meyman.presentation.ui.screens.profile.user

import android.util.Log
import android.widget.ImageView
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentUserProfileBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class UserProfileFragment :
    BaseFragment<FragmentUserProfileBinding, UserProfileViewModel>(R.layout.fragment_user_profile) {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    override val binding by viewBinding(FragmentUserProfileBinding::bind)
    override val viewModel: UserProfileViewModel by viewModels()

    override fun initialize() {
        setupSubscribes()
        profile()
    }

    private fun profile() = with(binding) {
        viewModel.fetchUserProfile("Bearer ${userPreferencesData.accessToken}")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.userProfileState.collect {
                    Log.e("ololo", "RPF: ${it}")
                    when (it) {
                        is UIState.Error -> {
                            Log.e("ololo", "RPAE: ${it.error}")
                        }

                        is UIState.Loading -> {
                            ivProfileIcon.setImage(R.drawable.chort.toString())
                        }

                        is UIState.Success -> {
                            val http = convertToHttpsUrl(it.data.image.toString())
                            binding.tvProfileName.text = it.data.username
                            binding.ivProfileIcon.setImage(http)
                            userPreferencesData.userId = it.data.id
                            Log.e("ololo", "RPAS: ${it.data}")
                        }
                    }
                }
            }
        }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .diskCacheStrategy(DiskCacheStrategy.NONE) // Для тестирования
            .skipMemoryCache(true)
            .into(this)
    }

    fun convertToHttpsUrl(httpUrl: String): String {
        // Проверяем, начинается ли URL с "http://" (без "s")
        if (httpUrl.startsWith("http://")) {
            // Заменяем "http://" на "https://"
            return "https://" + httpUrl.substring(7)
        }

        // Если URL уже начинается с "https://", то оставляем его без изменений
        if (httpUrl.startsWith("https://")) {
            return httpUrl
        }

        // Если URL не начинается ни с "http://", ни с "https://", вернем его без изменений
        return httpUrl
    }

    override fun setupSubscribes() = with(binding) {

        btnUserChange.setOnClickListener {
            // Переход на экран редактирования профиля пользователя
            findNavController().navigate(R.id.action_userProfileFragment_to_changeUserProfileFragment)
        }

        clCall.setOnClickListener {
            // Переход на экран связи
//            findNavController().navigate(UserProfileFragmentDirections.actionUserProfileFragmentToConnectFragment())
        }

        clRentOutHousing.setOnClickListener {
            // Реализовать переход на экран сдачи жилья

        }

        clRentCar.setOnClickListener {
            // Реализовать переход на экран сдачи авто
        }
    }
}