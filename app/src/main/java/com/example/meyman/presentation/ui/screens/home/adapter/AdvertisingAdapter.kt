package com.example.meyman.presentation.ui.screens.home.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemRecomedationBinding
import com.example.meyman.presentation.models.home.AdvertisingResultUI

class AdvertisingAdapter :
    ListAdapter<AdvertisingResultUI, AdvertisingAdapter.AdvertisingViewHolder>(diffUtil) {

    inner class AdvertisingViewHolder(val binding: ItemRecomedationBinding) :
        ViewHolder(binding.root) {

        fun onBind(item: AdvertisingResultUI?) = with(binding) {
            tvHotelName.text = item?.housingName
            Log.e("Images", "onBind: + ${item?.housingImage}")
            ivHotelImage.setImage("https://meyman.geeks.kg${item?.housingImage?.getOrNull(0)}")
            tvLocation.text = item?.address
            val stars = item?.stars
            when (stars) {
                1 -> {
                    ivStar1.visibility = View.VISIBLE
                }
                2 -> {
                    ivStar1.visibility = View.VISIBLE
                    ivStar2.visibility = View.VISIBLE
                }
                3 -> {
                    ivStar1.visibility = View.VISIBLE
                    ivStar2.visibility = View.VISIBLE
                    ivStar3.visibility = View.VISIBLE
                }
                4 -> {
                    ivStar1.visibility = View.VISIBLE
                    ivStar2.visibility = View.VISIBLE
                    ivStar3.visibility = View.VISIBLE
                    ivStar4.visibility = View.VISIBLE
                }
                5 -> {
                    ivStar1.visibility = View.VISIBLE
                    ivStar2.visibility = View.VISIBLE
                    ivStar3.visibility = View.VISIBLE
                    ivStar4.visibility = View.VISIBLE
                    ivStar5.visibility = View.VISIBLE
                }
            }
        }
    }
    fun ImageView.setImage(uri: String?) {
        Glide.with(this)
            .load(uri)
            .into(this)
    }

    fun convertToHttpsUrl(httpUrl: String): String {
        if (httpUrl.startsWith("http://")) {
            return "https://" + httpUrl.substring(7)
        }
        if (httpUrl.startsWith("https://")) {
            return httpUrl
        }
        return httpUrl
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdvertisingViewHolder {
        return AdvertisingViewHolder(
            ItemRecomedationBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: AdvertisingViewHolder, position: Int) {
        holder.onBind(getItem(position))
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<AdvertisingResultUI>() {
            override fun areItemsTheSame(oldItem: AdvertisingResultUI, newItem: AdvertisingResultUI): Boolean {
                return oldItem.id == newItem.id
            }
            override fun areContentsTheSame(oldItem: AdvertisingResultUI, newItem: AdvertisingResultUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}