package com.example.meyman.presentation.ui.screens.search_results

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CompoundButton
import android.widget.ImageView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.meyman.databinding.ItemSearchResultBinding
import com.example.meyman.presentation.models.hotels.ResultsHotelItemUI

class SearchResultsAdapter(
    private val onClick: (ResultsHotelItemUI) -> Unit
) :
    ListAdapter<ResultsHotelItemUI, SearchResultsAdapter.ViewHolder>(diffUtil) {
    var onLikeClickOn: ((model: ResultsHotelItemUI, like: CompoundButton) -> Unit)? = null
    var onLikeClickOff: ((name: String, like: CompoundButton) -> Unit)? = null
    val onButtonClick: ((id: Int) -> Unit)? = null

    inner class ViewHolder(private val binding: ItemSearchResultBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(dataItem: ResultsHotelItemUI) = with(binding) {
            tvHotel.text = dataItem.housingName
            tvLocation.text = dataItem.address
            ivSearchResult.setImage("https://meyman.geeks.kg${dataItem.housingImage}")
            tvRating.text = dataItem.stars.toString()
            tvLocation.text = dataItem.address
            tvReviews.text = (dataItem.reviews?.count().toString()+" отзывов")
            val stars = dataItem.stars
            if (stars == 1) {
                ivStar1.visibility = View.VISIBLE
            } else if (stars == 2) {
                ivStar1.visibility = View.VISIBLE
                ivStar2.visibility = View.VISIBLE
            } else if (stars == 3) {
                ivStar1.visibility = View.VISIBLE
                ivStar2.visibility = View.VISIBLE
                ivStar3.visibility = View.VISIBLE
            } else if (stars == 4) {
                ivStar1.visibility = View.VISIBLE
                ivStar2.visibility = View.VISIBLE
                ivStar3.visibility = View.VISIBLE
                ivStar4.visibility = View.VISIBLE
            } else if (stars == 5) {
                ivStar1.visibility = View.VISIBLE
                ivStar2.visibility = View.VISIBLE
                ivStar3.visibility = View.VISIBLE
                ivStar4.visibility = View.VISIBLE
                ivStar5.visibility = View.VISIBLE
            }

            itemView.setOnClickListener {
                onClick(dataItem)
            }

            binding.like.setOnClickListener {
                if (binding.like.isChecked) {
                    onLikeClickOn?.invoke(dataItem, binding.like)
                } else {
                    onLikeClickOff?.invoke(dataItem.id.toString(), binding.like)
                }
            }
        }

        fun ImageView.setImage(uri: String) {
            Glide.with(this)
                .load(uri)
                .into(this)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemSearchResultBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultsHotelItemUI>() {
            override fun areItemsTheSame(
                oldItem: ResultsHotelItemUI,
                newItem: ResultsHotelItemUI
            ): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(
                oldItem: ResultsHotelItemUI,
                newItem: ResultsHotelItemUI
            ): Boolean {
                return oldItem == newItem
            }
        }
    }
}