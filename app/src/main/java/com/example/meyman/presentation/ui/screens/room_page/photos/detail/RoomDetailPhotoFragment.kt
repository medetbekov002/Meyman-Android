package com.example.meyman.presentation.ui.screens.room_page.photos.detail

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class RoomDetailPhotoFragment : Fragment() {

    companion object {
        fun newInstance() = RoomDetailPhotoFragment()
    }

    private lateinit var viewModel: RoomDetailPhotoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_detail_photo, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RoomDetailPhotoViewModel::class.java)
        // TODO: Use the ViewModel
    }

}