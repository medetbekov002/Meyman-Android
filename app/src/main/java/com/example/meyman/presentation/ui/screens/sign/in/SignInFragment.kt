package com.example.meyman.presentation.ui.screens.sign.`in`

import android.annotation.SuppressLint
import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.Toast
import androidx.core.content.ContextCompat
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.LoginDto
import com.example.meyman.data.remote.dtos.auth.RegisterDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentSignInBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.auth.toUI
import com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount.VerifyAccountFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentSignInBinding
    private val viewModel: SignInViewModel by viewModels()
    private var originalMode: Int? = null

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        originalMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        )
        binding = FragmentSignInBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun customAdjustResize() {
        with(binding) {
            root.viewTreeObserver.addOnGlobalLayoutListener {
                val rect = Rect()
                root.getWindowVisibleDisplayFrame(rect)

                val screenHeight = root.rootView.height
                val visibleHeight = rect.bottom - rect.top

                val heightDifference = screenHeight - visibleHeight

                if (heightDifference >= 200) {
                    val layoutParams = root.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParams.bottomMargin = heightDifference - 100
                    root.requestLayout()
                } else {
                    val layoutParams = root.layoutParams as ViewGroup.MarginLayoutParams
                    layoutParams.bottomMargin = 30
                    root.requestLayout()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        customAdjustResize()
        setupSubscribes()
        register()
        login()
    }

    @SuppressLint("ResourceType")
    private fun setupSubscribes() = with(binding) {

        tvSignUp.setOnClickListener {
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tilEmail.visibility = View.GONE
            tilPassword.visibility = View.GONE
            tvForgotPassword.visibility = View.GONE
            btnSignIn.visibility = View.GONE
            tilRegEmail.visibility = View.VISIBLE
            tilRegUserName.visibility = View.VISIBLE
            tilConfirmPassword.visibility = View.VISIBLE
            tilRegPassword.visibility = View.VISIBLE
            btnRegister.visibility = View.VISIBLE
        }
        tvSignIn.setOnClickListener {
            tvSignUp.setTextColor(ContextCompat.getColor(requireContext(), R.color.black))
            tvSignIn.setTextColor(ContextCompat.getColor(requireContext(), R.color.blue1))
            tilRegEmail.visibility = View.GONE
            tilRegUserName.visibility = View.GONE
            tilConfirmPassword.visibility = View.GONE
            tilRegPassword.visibility = View.GONE
            btnRegister.visibility = View.GONE
            btnSignIn.visibility = View.VISIBLE
            tvForgotPassword.visibility = View.VISIBLE
            tilEmail.visibility = View.VISIBLE
            tilPassword.visibility = View.VISIBLE
        }
    }

    private fun login() = with(binding) {
        tvForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_guestProfileFragment_to_forgotPasswordFragment)
            dismiss()
        }

        val bundle = Bundle()
        btnSignIn.setOnClickListener {
            val email = etEmail.text.toString().trim()
            val password = etPassword.text.toString().trim()
            val model = LoginDto(password, email)
            if (!isGmailAddressValid(email)) {
                tilEmail.setErrorWithTimeout("Введите корректную почту")
            } else if (!isPasswordValid(password)) {
                tilPassword.setErrorWithTimeout("Введите корректный пароль")
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getLoginState(model).collect {
                            when (it) {
                                is Resource.Loading -> {}

                                is Resource.Error -> {
                                    Toast.makeText(
                                        requireContext(),
                                        "Введите корректные данные",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                is Resource.Success -> {
                                    it.data?.toUI()
                                    userPreferencesData.apply {
                                        isAuthorized = true
                                        accessToken = it.data!!.tokens.access
                                        refreshToken = it.data.tokens.refresh
                                    }
                                    dismiss()
                                    findNavController().navigate(R.id.action_guestProfileFragment_to_userProfileFragment)
                                    bundle.putString("email", etRegEmail.text.toString())
                                    val verifyFragment = VerifyAccountFragment()
                                    verifyFragment.arguments = bundle
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun register() = with(binding) {
        btnRegister.setOnClickListener {
            val email = binding.etRegEmail.text.toString().trim()
            val username = binding.etRegUserName.text.toString().trim()
            val password = binding.etRegPassword.text.toString().trim()
            val confirmPassword = binding.etConfirmPassword.text.toString().trim()
            val usertype = "client"
            val model = RegisterDto(email, username, usertype, password)
            tilRegUserName.error = null
            tilRegEmail.error = null
            tilRegPassword.error = null
            tilConfirmPassword.error = null
            if (!isUsernameValid(username)) {
                tilRegUserName.setErrorWithTimeout("Введите корректное имя и фамилие")
            } else if (!isGmailAddressValid(email)) {
                tilRegEmail.setErrorWithTimeout("Введите корректную почту")
            } else if (!isPasswordValid(password)) {
                tilRegPassword.setErrorWithTimeout("Введите корректный пароль")
            } else if (confirmPassword != password) {
                tilConfirmPassword.setErrorWithTimeout("Повторите введеный пароль")
            } else {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getRegisterState(model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }

                                is Resource.Error -> {
                                    Toast.makeText(
                                        requireContext(),
                                        "Данный email уже зарегистрирован",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                is Resource.Success -> {
                                    userPreferencesData.apply {
                                        userEmail = binding.etRegEmail.text.toString().trim()
                                    }
                                    dismiss()
                                    findNavController().navigate(R.id.action_guestProfileFragment_to_verifyAccountFragment)
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    fun isUsernameValid(username: String): Boolean {
        val words = username.split(" ")
        if (words.size != 2) {
            return false
        }
        for (word in words) {
            if (!word.all { it.isLetter() }) {
                return false
            }
        }
        return true
    }

    fun isGmailAddressValid(email: String): Boolean {
        val emailPattern = "[a-zA-Z0-9._-]+@gmail.com"
        return email.matches(emailPattern.toRegex())
    }

    fun isPasswordValid(password: String): Boolean {
        if (password.length <= 6) {
            return false
        }
        for (char in password) {
            if (!char.isDigit() && !char.isLetter()) {
                return false
            }
        }
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