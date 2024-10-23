package com.example.meyman.presentation.ui.screens.hotel_page.rooms

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meyman.presentation.models.rooms.list.RoomListImagesItemUI
import com.example.meyman.databinding.ItemPhotoRoomsBinding

class PhotoAdapter() : ListAdapter<RoomListImagesItemUI, PhotoAdapter.PhotoViewHolder>(diffUtil) {
    inner class PhotoViewHolder(val binding: ItemPhotoRoomsBinding) : ViewHolder(binding.root) {
        fun onBind(model: RoomListImagesItemUI) {
            Log.e("ololo", "onBind: " + {model})
            binding.ivPhoto.setImage("https://meyman.geeks.kg${model.image}")
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder =
        PhotoViewHolder(ItemPhotoRoomsBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) {
        getItem(position).let { holder.onBind(it) }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<RoomListImagesItemUI>() {
            override fun areItemsTheSame(oldItem: RoomListImagesItemUI, newItem: RoomListImagesItemUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: RoomListImagesItemUI, newItem: RoomListImagesItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}