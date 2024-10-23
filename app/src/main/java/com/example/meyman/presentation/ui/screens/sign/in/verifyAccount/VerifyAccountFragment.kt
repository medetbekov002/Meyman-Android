package com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount

import android.app.Dialog
import android.graphics.Color
import android.graphics.Rect
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.Window
import android.view.WindowManager
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.VerifyDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentVerifyAccountBinding
import com.example.meyman.presentation.base.Resource
import com.example.meyman.presentation.models.auth.toUI
import com.google.android.material.button.MaterialButton
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class VerifyAccountFragment : Fragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentVerifyAccountBinding
    private val viewModel: VerifyAccountViewModel by viewModels()
    private var originalMode: Int? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        originalMode = WindowManager.LayoutParams.SOFT_INPUT_ADJUST_NOTHING
        activity?.window?.setSoftInputMode(
            WindowManager.LayoutParams.SOFT_INPUT_ADJUST_RESIZE
        )
        binding = FragmentVerifyAccountBinding.inflate(inflater, container, false)
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
        customAdjustResize()
        Log.e("ololo", "onViewCreated: + ${userPreferencesData.userEmail}" )
        super.onViewCreated(view, savedInstanceState)
        binding.btnAccept.setOnClickListener {
            val code = binding.etCode.text.toString()
            val email = userPreferencesData.userEmail
            val model = VerifyDto(code, email)
            Log.d("qwerty", "$model")
            Log.d("MyApp", "Email: $email, code: $code")
            if (code.length == 4) {
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                        viewModel.getVerifyState(model).collect {
                            when (it) {
                                is Resource.Loading -> {
                                }
                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                    Log.e("ololo", "setupSubscribes11111: " + userPreferencesData.userEmail)
                                    Toast.makeText(
                                        requireContext(),
                                        "Не правильный код",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }
                                is Resource.Success -> {
                                    val list = it.data?.toUI()
                                    customAlertDialog()
                                    findNavController().navigate(R.id.action_verifyAccountFragment_to_userProfileFragment)
                                    Log.e("MyApp", "setupSubscribes: $list")
                                }
                            }
                        }
                    }
                }
            }
        }
    }

    private fun customAlertDialog() {
        val dialog = Dialog(requireContext())
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.custom_alert_dialog)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val btnContinue: MaterialButton = dialog.findViewById(R.id.btn_continue)

        btnContinue.setOnClickListener {
            dialog.dismiss()
        }
        dialog.show()
    }
}