package com.example.meyman.presentation.ui.screens.hotel_page

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemPhotoRoomsBinding
import com.example.meyman.presentation.models.hotels.HousingImagesItemUI

class HotelPagePhotoAdapter() :
    ListAdapter<HousingImagesItemUI, HotelPagePhotoAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(val binding: ItemPhotoRoomsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: HousingImagesItemUI) {
            binding.ivPhoto.setImage("https://meyman.geeks.kg${model.image}")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPhotoRoomsBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<HousingImagesItemUI>() {
            override fun areItemsTheSame(oldItem: HousingImagesItemUI, newItem: HousingImagesItemUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: HousingImagesItemUI, newItem: HousingImagesItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}