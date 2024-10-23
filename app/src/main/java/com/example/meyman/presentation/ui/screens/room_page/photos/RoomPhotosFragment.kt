package com.example.meyman.presentation.ui.screens.room_page.photos

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class RoomPhotosFragment : Fragment() {

    companion object {
        fun newInstance() = RoomPhotosFragment()
    }

    private lateinit var viewModel: RoomPhotosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_photos, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(RoomPhotosViewModel::class.java)
        // TODO: Use the ViewModel
    }

}