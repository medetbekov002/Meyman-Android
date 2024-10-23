//package com.example.meyman.presentation.ui.screens.booking.booking_detail
//
//import android.os.Bundle
//import android.util.Log
//import android.view.LayoutInflater
//import android.view.View
//import android.view.ViewGroup
//import androidx.fragment.app.Fragment
//import androidx.fragment.app.viewModels
//import androidx.lifecycle.Lifecycle
//import androidx.lifecycle.lifecycleScope
//import androidx.lifecycle.repeatOnLifecycle
//import com.example.meyman.databinding.FragmentBookingDetailBinding
//import com.example.meyman.presentation.state.UIState
//import dagger.hilt.android.AndroidEntryPoint
//import kotlinx.coroutines.launch
//
//@AndroidEntryPoint
//class BookingDetailFragment : Fragment() {
//
//    private lateinit var binding: FragmentBookingDetailBinding
//    private val viewModel: BookingDetailViewModel by viewModels()
//
//    override fun onCreateView(
//        inflater: LayoutInflater, container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        binding = FragmentBookingDetailBinding.inflate(inflater, container, false)
//        return binding.root
//    }
//
//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        callDetailApi()
//    }
//
//    private fun callDetailApi() {
//        viewModel.getBookingById(id)
//        viewLifecycleOwner.lifecycleScope.launch {
//            viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.STARTED) {
//                viewModel.bookingDetail.collect {
//                    Log.e("ololo", "BookingDetailFragment: ${it}")
//                    when (it) {
//                        is UIState.Empty -> {}
//                        is UIState.Error -> {
//                            Log.e("ololo", "BookingDetailFragment-error: ${it.error}")
//                        }
//
//                        is UIState.Loading -> {}
//                        is UIState.Success -> {
//                            Log.e("ololo", "BookingDetailFragment-success: ${it.data}")
//                        }
//                    }
//                }
//            }
//        }
//    }
//
//}