package com.example.meyman.presentation.ui.screens.booking

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.viewmodel.viewModelFactory
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.ItemBookingBinding
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI
import com.example.meyman.presentation.models.reservation.ReservationResultUI
import com.example.meyman.presentation.ui.screens.hotel_page.rooms.RoomsViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

class ReservationAdapter() : ListAdapter<ReservationResultUI, ReservationAdapter.BookingViewHolder>(diffUtil) {


    inner class BookingViewHolder(private val binding: ItemBookingBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ReservationResultUI) = with(binding) {
           val reservId =  dataItem.id
            Log.e("erbol", "adapter: " + dataItem.room_name + " " + dataItem.housing )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookingViewHolder {
        return BookingViewHolder(
            ItemBookingBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: BookingViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ReservationResultUI>() {
            override fun areItemsTheSame(
                oldItem: ReservationResultUI,
                newItem: ReservationResultUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ReservationResultUI,
                newItem: ReservationResultUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }

}