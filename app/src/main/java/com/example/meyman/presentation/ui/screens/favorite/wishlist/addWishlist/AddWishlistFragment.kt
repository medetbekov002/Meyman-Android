package com.example.meyman.presentation.ui.screens.favorite.wishlist.addWishlist

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.data.remote.dtos.favorite.wishlist.WishlistDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentAddWishlistBinding
import com.example.meyman.presentation.base.Resource
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AddWishlistFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentAddWishlistBinding
    private val viewModel: AddWishlistViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.btnSave.setOnClickListener {
            val wishlistName = binding.etWishlistName.text.toString().trim()
            val model = WishlistDto(userPreferencesData.userId, wishlistName)
            viewLifecycleOwner.lifecycleScope.launch {
                viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
                    viewModel.fetchAddWishlist("Bearer ${userPreferencesData.accessToken}", model)
                        .collect {
                            when (it) {
                                is Resource.Loading -> {
                                }

                                is Resource.Error -> {
                                    Log.e("ololo", "setupSubscribes11111: " + it.message)
                                }

                                is Resource.Success -> {
                                    dismiss()
                                    Log.e("ololo", "addWishlist: " + it.data?.user)
                                }
                            }
                        }
                }
            }
        }
    }
}