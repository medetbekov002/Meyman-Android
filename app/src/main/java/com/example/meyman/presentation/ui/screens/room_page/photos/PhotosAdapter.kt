package com.example.meyman.presentation.ui.screens.room_page.photos

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemPhotoLinearBinding
import com.example.meyman.presentation.models.rooms.page.RoomImagesItemUI

class PhotosAdapter() :
    ListAdapter<RoomImagesItemUI, PhotosAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(val binding: ItemPhotoLinearBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: RoomImagesItemUI) {
            Log.e("alala", "onBind: " + { model.image })
            binding.ivPhotoLinear.setImage(model.image)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(
            ItemPhotoLinearBinding.inflate(
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
        val diffUtil = object : DiffUtil.ItemCallback<RoomImagesItemUI>() {
            override fun areItemsTheSame(oldItem: RoomImagesItemUI, newItem: RoomImagesItemUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: RoomImagesItemUI, newItem: RoomImagesItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}