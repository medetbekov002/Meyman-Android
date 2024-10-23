package com.example.meyman.domain.utils.models

import com.example.meyman.core.Constant


data class NewsModel(
    val count: Int,
    val next: String,
    val previous: String,
    val results: List<NewsItemModel>
)

data class NewsItemModel(
    val id: Int = Constant.DEFAULT_ID,
    val author_fullname: String,
    val content: String,
    val image: String,
    val is_favorite: Boolean,
    val link: String,
    val published_date: String,
    val title: String
)

data class News(
    val id: Int = Constant.DEFAULT_ID,
    val author_fullname: String,
    val content: String,
    val image: String,
    val is_favorite: Boolean,
    val link: String,
    val published_date: String,
    val title: String
)