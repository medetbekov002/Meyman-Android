package com.example.meyman.presentation.ui.screens.profile.user.change.exitAccount

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentChangeUserProfileBinding
import com.example.meyman.databinding.FragmentExitAccountBinding
import com.example.meyman.databinding.FragmentSearchResultsBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class ExitAccountFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentExitAccountBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentExitAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) = with(binding) {
        btnCancel.setOnClickListener {
            dismiss()
        }
        btnDelete.setOnClickListener {
            userPreferencesData.isAuthorized = false
            userPreferencesData.accessToken = ""
            userPreferencesData.refreshToken = ""
            // Получите доступ к FragmentManager
            val fragmentManager = requireActivity().supportFragmentManager

            // Закройте текущий фрагмент (ChangeUserProfileFragment)
            fragmentManager.popBackStack()
            dismiss()
        }

    }

}