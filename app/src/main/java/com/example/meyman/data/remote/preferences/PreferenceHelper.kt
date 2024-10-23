package com.example.meyman.data.remote.preferences

import android.content.Context
import android.content.SharedPreferences

class PreferenceHelper(context: Context) {

    private val preference: SharedPreferences = context.getSharedPreferences("userStatus", Context.MODE_PRIVATE)

    operator fun invoke() = preference
}