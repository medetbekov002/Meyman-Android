package com.example.meyman.presentation.ui.screens.profile.guest

import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.NavDirections
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentGuestProfileBinding
import com.example.meyman.presentation.ui.screens.sign.`in`.SignInFragment
import com.example.meyman.presentation.ui.screens.sign.`in`.verifyAccount.VerifyAccountFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class GuestProfileFragment : BaseFragment<FragmentGuestProfileBinding, GuestProfileViewModel>(R.layout.fragment_guest_profile) {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    override val binding by viewBinding(FragmentGuestProfileBinding::bind)
    override val viewModel: GuestProfileViewModel by viewModels()
    private var dataFrom = "IDI NH"

    override fun initialize() {
        super.initialize()
        getData()
    }

    override fun setupSubscribes() = with(binding) {
        val email = arguments?.getString("email")
        btnSignIn.setOnClickListener {
            val bottomSheetFragment = SignInFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
          bottomSheetFragment.dialog?.window?.setBackgroundDrawableResource(R.drawable.rounder)
        }
        clCall.setOnClickListener{
            Toast.makeText(requireContext(), "${userPreferencesData.userEmail}", Toast.LENGTH_SHORT).show()
            val action: NavDirections =
                GuestProfileFragmentDirections.actionGuestProfileFragmentToConnectFragment()
            findNavController().navigate(action)
        }
    }

    private fun getData() {

    }
}