package com.example.meyman.presentation.ui.screens.profile.user.change

import android.app.Activity
import android.content.Intent
import android.net.Uri
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ImageView
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.dtos.profile.password.ChangeUserPasswordDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentChangeUserProfileBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.profile.user.change.exitAccount.ExitAccountFragment
import com.example.meyman.presentation.ui.screens.sign.`in`.SignInFragment

import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.asRequestBody
import java.io.ByteArrayInputStream
import java.io.File
import java.io.InputStream
import javax.inject.Inject

@AndroidEntryPoint
class ChangeUserProfileFragment :
    BaseFragment<FragmentChangeUserProfileBinding, ChangeUserProfileViewModel>(R.layout.fragment_change_user_profile) {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private var uri: Uri = Uri.EMPTY
    override val binding by viewBinding(FragmentChangeUserProfileBinding::bind)
    override val viewModel: ChangeUserProfileViewModel by viewModels()

    private var localAva = false
    private val launcher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
            if (it.resultCode == Activity.RESULT_OK && it.data != null) {
                uri = it.data?.data!!
                localAva = true
                binding.ivUserAvatar.setImage(uri.toString())
            }
        }

    fun ImageView.setImage(url: String) {
        Glide.with(this).load(url).into(this)
    }

    override fun initialize() {
        profile()
        changeUserProfile()
        changeUserPassword()
    }

    private fun saveImage() {
        val pickImageIntent = Intent()
        pickImageIntent.type = "image/*"
        pickImageIntent.action = Intent.ACTION_PICK
        launcher.launch(pickImageIntent)
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

        ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
        ivUserAvatar.setOnClickListener {
            saveImage()
        }

        binding.flChangePassword.setOnClickListener {
            tilOldPassword.visibility = View.VISIBLE
            tilNewPassword.visibility = View.VISIBLE
            btnUpdatePassword.visibility = View.VISIBLE

            flChangePassword.setOnClickListener {
                tilOldPassword.visibility = View.GONE
                tilNewPassword.visibility = View.GONE
                btnUpdatePassword.visibility = View.GONE
            }
        }
        binding.flExitAccount.setOnClickListener {
            val bottomSheetFragment = ExitAccountFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
            bottomSheetFragment.dialog?.window?.setBackgroundDrawableResource(R.drawable.rounder)
        }
    }

    private fun changeUserProfile() = with(binding) {
        tvSave.setOnClickListener {
            val fullName = etUserName.text.toString().trim()
            val phone = etUserPhoneNumber.text?.trim()
            val phoneNumber = phone?.replace("[+]".toRegex(), "")
            Log.e("ABOBA", "setupSubscribes: + ${fullName + phoneNumber} ")
            val fullnamePart = RequestBody.create("fullname".toMediaTypeOrNull(), fullName)
            val phoneNumberPart =
                RequestBody.create("phone_number".toMediaTypeOrNull(), phoneNumber!!)
            Log.e("ABOBA", "setupSubscribes: + ${fullnamePart}, ${phoneNumberPart} ")


            var inputStream: InputStream = ByteArrayInputStream(byteArrayOf())
            if (uri != Uri.EMPTY) {
                inputStream = context?.contentResolver?.openInputStream(uri)!!
            }

            val file = File(context?.cacheDir, "temp_image.jpg")


            inputStream.let { input ->
                file.outputStream().use { output ->
                    input.copyTo(output)
                }
            }

            val imageRequestBody = file.asRequestBody("image/*".toMediaTypeOrNull())
            val avatar = imageRequestBody.let {
                MultipartBody.Part.createFormData(
                    "image", file.name,
                    it
                )
            }
            Log.e("ABOBA", "setupSubscribes:   ${avatar} + ${fullnamePart} + ${phoneNumberPart}")
            Log.e("ABOBA", "setupSubscribes:   ${avatar} + ${fullName} + ${phoneNumber}")
            viewModel.fetchChangeUserProfile(
                "Bearer ${userPreferencesData.accessToken}",
                avatar,
                fullnamePart,
                phoneNumberPart
            )
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.changeUserProfileState.collect {
                        Log.e("ololo", "RPF: ${it}")
                        when (it) {
                            is UIState.Error -> {
                                Log.e("ololo", "RPAE: ${it.error}")
                            }

                            is UIState.Loading -> {}
                            is UIState.Success -> {
                                Log.e("ololo", "RPAS: ${it.data}")
                            }
                        }
                    }
                }
            }
        }
    }

    private fun profile() {
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

                        }

                        is UIState.Success -> {
                            val http = convertToHttpsUrl(it.data.image.toString())
                            binding.etUserName.setText(it.data.username)
                            binding.tvEmail.text = it.data.email
                            binding.etUserPhoneNumber.setText(it.data.phoneNumber)
                            binding.ivUserAvatar.setImage(http)
                            Log.e("ololo", "RPAS: ${it.data}")
                        }
                    }
                }
            }
        }
    }

    private fun changeUserPassword() = with(binding) {
        btnUpdatePassword.setOnClickListener {
            val oldPassword = etOldPassword.text.toString().trim()
            val newPassword = etNewPassword.text.toString().trim()
            val model = ChangeUserPasswordDto(oldPassword, newPassword)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.fetchChangeUserPassword(
                        "Bearer ${userPreferencesData.accessToken}",
                        model
                    ).collect {
                        when (it) {
                            is Resource.Loading -> {
                            }

                            is Resource.Error -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.message)
                            }

                            is Resource.Success -> {
                                Log.e("ololo", "setupSubscribes11111: " + it.data)
                            }
                        }
                    }
                }
            }
        }
    }
}