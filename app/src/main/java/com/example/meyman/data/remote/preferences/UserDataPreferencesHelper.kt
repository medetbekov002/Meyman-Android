package com.example.meyman.data.remote.preferences

import javax.inject.Inject

const val PREF_IS_AUTHORIZED = "is_authorized"
const val PREF_REFRESH_TOKEN: String = "refresh_token"
const val PREF_ACCESS_TOKEN: String = "access_token"
const val PREF_USER_EMAIL: String = "email"
const val KEY_FOR_USER_ID = "KEY_FOR_USER_ID"
const val PREF_USER_PASSWORD: String = "password"
const val PREF_CHILDREN: String = "children"
const val PREF_ADULTS: String = "adults"
const val PREF_ON_BOARD = "on_board"
const val PREF_HOTEL_ID = "hotel_ID"
const val PREF_ADDRESS = "address"
const val PREF_NAME_ = "name"

class UserDataPreferencesHelper @Inject constructor(
    private val preferences: PreferenceHelper
) {

    var isAuthorized : Boolean
        get() = preferences().getBoolean(PREF_IS_AUTHORIZED, false)
        set(value) = preferences().edit().putBoolean(PREF_IS_AUTHORIZED, value).apply()

    var refreshToken : String
        get() = preferences().getString(PREF_REFRESH_TOKEN, "null")!!
        set(value) = preferences().edit().putString(PREF_REFRESH_TOKEN, value).apply()

    var accessToken : String
        get() = preferences().getString(PREF_ACCESS_TOKEN, "null")!!
        set(value) = preferences().edit().putString(PREF_ACCESS_TOKEN, value).apply()

    var userEmail : String
        get() = preferences().getString(PREF_USER_EMAIL, "null")!!
        set(value) = preferences().edit().putString(PREF_USER_EMAIL, value).apply()

    var adress : String
        get() = preferences().getString(PREF_ADDRESS, "null")!!
        set(value) = preferences().edit().putString(PREF_ADDRESS, value).apply()

    var housingName : String
        get() = preferences().getString(PREF_NAME_, "null")!!
        set(value) = preferences().edit().putString(PREF_NAME_, value).apply()

    var saveOnBoard : Boolean
        get() = preferences().getBoolean(PREF_ON_BOARD, false)
        set(value) = preferences().edit().putBoolean(PREF_ON_BOARD, value).apply()

    var children : Int
        get() = preferences().getInt(PREF_CHILDREN, 0)
        set(value) = preferences().edit().putInt(PREF_CHILDREN, value).apply()

    var adults : Int
        get() = preferences().getInt(PREF_ADULTS, 0)
        set(value) = preferences().edit().putInt(PREF_ADULTS, value).apply()

    var userId : Int
        get() = preferences().getInt(KEY_FOR_USER_ID, 0)
        set(value) = preferences().edit().putInt(KEY_FOR_USER_ID, value).apply()

    var hotelId : Int
        get() = preferences().getInt(PREF_HOTEL_ID, 0)
        set(value) = preferences().edit().putInt(PREF_HOTEL_ID, value).apply()


}