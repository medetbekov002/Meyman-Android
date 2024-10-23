package com.example.meyman.data.remote.dtos.auth.reset_password

import com.google.gson.annotations.SerializedName

data class AnswerCodeDto(@SerializedName("code")
                         val code: String = "",
                         @SerializedName("detail")
                         val detail: String = "")