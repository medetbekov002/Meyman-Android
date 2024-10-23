package com.example.meyman.presentation.ui.screens.forgot_password.updatePassword

import android.os.Bundle
import android.os.Handler
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.reset_password.PasswordDto
import com.example.meyman.databinding.FragmentUpdatePasswordBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.ui.screens.forgot_password.ForgotPasswordFragmentDirections
import com.example.meyman.presentation.ui.screens.room_page.RoomPageFragmentArgs
import com.example.meyman.presentation.ui.screens.sign.`in`.SignInFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class UpdatePasswordFragment : Fragment() {

    private lateinit var binding: FragmentUpdatePasswordBinding
    private val viewModel: UpdatePasswordViewModel by viewModels()
    private val args: UpdatePasswordFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentUpdatePasswordBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        forgotPassword()
        binding.ivBack.setOnClickListener {
            findNavController().navigateUp()
        }
    }

    private fun forgotPassword() = with(binding) {
        btnAccept.setOnClickListener {
            val password = etUpdatePassword.text.toString()
            val model = PasswordDto(password)
            val confirmPassword = etConfirmPassword.text.toString()
            if (!isPasswordValid(password)) {
                tilUpdatePassword.setErrorWithTimeout("введите корректный пароль")
            } else if (password != confirmPassword) {
                tilConfirmPassword.setErrorWithTimeout("введите повторный пароль")
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getPassword(args.code, model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }

                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                }

                                is Resource.Success -> {
                                    findNavController().navigate(R.id.action_updatePasswordFragment2_to_guestProfileFragment)
                                    val bottomSheetFragment = SignInFragment()
                                    bottomSheetFragment.show(
                                        parentFragmentManager,
                                        bottomSheetFragment.tag
                                    )
                                    bottomSheetFragment.dialog?.window?.setBackgroundDrawableResource(
                                        R.drawable.rounder
                                    )
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun isPasswordValid(password: String): Boolean {
        // Проверяем длину пароля
        if (password.length <= 6) {
            return false
        }

        // Проверяем, что пароль состоит из цифр и букв
        for (char in password) {
            if (!char.isDigit() && !char.isLetter()) {
                return false
            }
        }

        // Если прошли все проверки, пароль считается допустимым
        return true
    }

    fun TextInputLayout.setErrorWithTimeout(errorMessage: String) {
        error = errorMessage
        Handler().postDelayed({
            error = null
            val layoutParams = this.layoutParams
            val dpVal = 62f
            layoutParams.height = TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP,
                dpVal,
                context.resources.displayMetrics
            ).toInt()
            this.layoutParams = layoutParams
        }, 5000L)
    }
}