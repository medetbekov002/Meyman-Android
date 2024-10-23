package com.example.meyman.presentation.ui.screens.favorite.wishlist

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isGone
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentWishlistBinding
import com.example.meyman.presentation.state.UIState
import com.example.meyman.presentation.ui.screens.favorite.addInFavorite.WishlistAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class WishlistFragment : Fragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentWishlistBinding
    private val viewModel: WishlistViewModel by viewModels()
    private val adapter = WishlistMainAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentWishlistBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        if (!userPreferencesData.isAuthorized) {
            binding.rvWishlist.isGone = true
            binding.noDataLinear.isGone = false
            binding.signButton.isGone = false
            binding.signButton.setOnClickListener {
                findNavController().navigate(R.id.guestProfileFragment)
            }
        } else {
            binding.rvWishlist.isGone = false
            binding.noDataLinear.isGone = true
            binding.signButton.isGone = true
        }
        wishlist()
        deleteWishlist()
    }

    private fun wishlist() {
        viewModel.getWishlist("Bearer ${userPreferencesData.accessToken}")
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.wishlistState.collect {
                    when (it) {
                        is UIState.Error -> {}

                        is UIState.Loading -> {}

                        is UIState.Success -> {
                            if (it.data.isEmpty()) {
                                binding.rvWishlist.isGone = true
                                binding.likeLinear.isGone = false
                            } else
                                binding.rvWishlist.adapter = adapter
                            adapter.submitList(it.data)
                        }
                    }
                }
            }
        }
    }

    private fun deleteWishlist() {

    }
}