package com.example.meyman.presentation.ui.screens.room_page.tablayout.review

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.meyman.databinding.ItemReviewBinding
import com.example.meyman.presentation.models.review.ResultsReviewItemUI

class ReviewAdapter : ListAdapter<ResultsReviewItemUI, ReviewAdapter.ViewHolder>(
    diffUtil
) {

    inner class ViewHolder(private val binding: ItemReviewBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun onBind(result: ResultsReviewItemUI) = with(binding) {
            tvDescription.text = result.comment
        }
//        init {
//            itemView.setOnClickListener {
//                getItem(absoluteAdapterPosition)?.let { it1 -> onItemClick(it1.id) }
//            }
//        }
    }



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            ItemReviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        getItem(position)?.let {
            holder.onBind(it)
        }
    }

    companion object {
        val diffUtil = object : DiffUtil.ItemCallback<ResultsReviewItemUI>() {
            override fun areItemsTheSame(oldItem: ResultsReviewItemUI, newItem: ResultsReviewItemUI): Boolean {
                return oldItem.user == newItem.user
            }
            override fun areContentsTheSame(oldItem: ResultsReviewItemUI, newItem: ResultsReviewItemUI): Boolean {
                return oldItem == newItem
            }
        }
    }
}
