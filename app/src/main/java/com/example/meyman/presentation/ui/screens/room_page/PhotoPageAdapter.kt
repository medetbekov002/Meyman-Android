package com.example.meyman.presentation.ui.screens.room_page

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemPhotoRoomsBinding
import com.example.meyman.presentation.models.rooms.page.RoomImagesItemUI


class PhotoPageAdapter() :
    ListAdapter<RoomImagesItemUI, PhotoPageAdapter.ViewHolder>(diffUtil) {
    inner class ViewHolder(val binding: ItemPhotoRoomsBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun onBind(model: RoomImagesItemUI) {
            val http = convertToHttpsUrl(model.image)
            Log.e("ololo", "onBind: " + { model.image})
            binding.ivPhoto.setImage(http)
        }

        fun convertToHttpsUrl(httpUrl: String): String {
            // Проверяем, начинается ли URL с "http://" (без "s")
            if (httpUrl.startsWith("http://")) {
                // Заменяем "http://" на "https://"
                return "https://" + httpUrl.substring(7)
            }

            // Если URL уже начинается с "https://", то оставляем его без изменений
            if (httpUrl.startsWith("https://")) {
                return httpUrl
            }

            // Если URL не начинается ни с "http://", ни с "https://", вернем его без изменений
            return httpUrl
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