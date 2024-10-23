package com.example.meyman.presentation.ui.screens.room_page.tablayout.childrenAndExtraBeds

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.meyman.R

class ChildrenAndExtraBedsFragment : Fragment() {

    companion object {
        fun newInstance() = ChildrenAndExtraBedsFragment()
    }

    private lateinit var viewModel: ChildrenAndExtraBedsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_children_and_extra_beds, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(ChildrenAndExtraBedsViewModel::class.java)
        // TODO: Use the ViewModel
    }

}