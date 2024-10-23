package com.example.meyman.presentation.ui.screens.room_page

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.databinding.ItemRoomAmenitiesBinding

class RoomAmenitiesAdapter(val list: List<String>) :
    RecyclerView.Adapter<RoomAmenitiesAdapter.RoomAmenitiesViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RoomAmenitiesViewHolder =
        RoomAmenitiesViewHolder(
            ItemRoomAmenitiesBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = list.size

    override fun onBindViewHolder(holder: RoomAmenitiesViewHolder, position: Int) {
        holder.onBind(list[position])
    }

    class RoomAmenitiesViewHolder(private val binding: ItemRoomAmenitiesBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(text: String) {
            binding.tvWifi.text = text
        }
    }
}