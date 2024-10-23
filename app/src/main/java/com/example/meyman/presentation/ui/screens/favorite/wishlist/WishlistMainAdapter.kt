package com.example.meyman.presentation.ui.screens.favorite.wishlist

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemWishlistGridBinding
import com.example.meyman.presentation.models.favorite.wishlist.AnswerWishlistUI

class WishlistMainAdapter :
    ListAdapter<AnswerWishlistUI, WishlistMainAdapter.MainWishlistViewHolder>(diffUtil) {

    inner class MainWishlistViewHolder(val binding: ItemWishlistGridBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(item: AnswerWishlistUI?) {
            binding.tvRegion.text = item?.title
            binding.tvObjectCount.text = "${item?.favoriteCount} объектов"
        }
    }

    fun ImageView.setImage(uri: String) {
        Glide.with(this)
            .load(uri)
            .into(this)
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WishlistMainAdapter.MainWishlistViewHolder {
        return MainWishlistViewHolder(
            ItemWishlistGridBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: WishlistMainAdapter.MainWishlistViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AnswerWishlistUI>() {
            override fun areItemsTheSame(
                oldItem: AnswerWishlistUI,
                newItem: AnswerWishlistUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: AnswerWishlistUI,
                newItem: AnswerWishlistUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}