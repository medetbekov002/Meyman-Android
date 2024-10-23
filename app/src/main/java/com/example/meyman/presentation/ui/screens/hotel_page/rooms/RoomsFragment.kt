package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.meyman.databinding.FragmentRoomsBinding
import com.example.meyman.presentation.state.UIState
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RoomsFragment : Fragment() {

    private lateinit var binding: FragmentRoomsBinding
    private val viewModel: RoomsViewModel by viewModels()
    private val args: RoomsFragmentArgs by navArgs()
    private val adapter = RoomsAdapter(this::onItemClick)

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRoomsBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupSubscribes()
    }

    private fun initialize() {
        binding.rvChooseRoom.adapter = adapter
    }

    private fun setupSubscribes() {
        subscribeToFetchRooms()

    }

    private fun onItemClick(id: Int) {
        findNavController().navigate(RoomsFragmentDirections.actionRoomsFragmentToRoomPageFragment(id))
    }
    private fun onButtonClick(id: Int) {
        findNavController().navigate(RoomsFragmentDirections.actionRoomsFragmentToRoomBookingFragment(id))
    }

    private fun subscribeToFetchRooms() {
        val id = arguments?.getInt("id")
        viewModel.getChooseRoomState(id!!)
        viewLifecycleOwner.lifecycleScope.launch {
            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                viewModel.roomsState.collect {
                    when (it) {
                        is UIState.Error -> {
                            Log.e("erbol", "rooms: " + it.error )
//                                binding.progressBar.isVisible = false
                        }

                        is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                        }

                        is UIState.Success -> {
                            Log.e("erbol", "rooms: " + it.data.rooms )
//                                binding.progressBar.isVisible = false
                            adapter.submitList(it.data.rooms)
                            val itemCount = adapter.itemCount
                            binding.textView.text = "$itemCount варианта"
                        }
                        else -> {}
                    }
                }
            }
        }
    }

}