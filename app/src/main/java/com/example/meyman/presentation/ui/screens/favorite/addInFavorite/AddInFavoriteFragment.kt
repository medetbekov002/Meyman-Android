package com.example.meyman.presentation.ui.screens.favorite.addInFavorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentAddInFavoriteBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.favorite.wishlist.addWishlist.AddWishlistFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class AddInFavoriteFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentAddInFavoriteBinding
    private val viewModel: AddInFavoriteViewModel by viewModels()
    private val adapter = WishlistAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAddInFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        wishlist()

        binding.clAddNewWishlist.setOnClickListener {
            val bottomSheetFragment = AddWishlistFragment()
            bottomSheetFragment.show(parentFragmentManager, bottomSheetFragment.tag)
            bottomSheetFragment.dialog?.window?.setBackgroundDrawableResource(R.drawable.rounder)
        }
    }

    private fun wishlist() {
        viewModel.getWishlist("Bearer ${userPreferencesData.accessToken}")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.wishlistState.collect {
                    when (it) {
                        is UIState.Error -> {
//                                binding.progressBar.isVisible = false
                        }

                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
//                                binding.progressBar.isVisible = false
                            binding.rvWishlist.adapter = adapter
                            adapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }

}