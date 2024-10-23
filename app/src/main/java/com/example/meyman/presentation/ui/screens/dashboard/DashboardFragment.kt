package com.example.meyman.presentation.ui.screens.dashboard

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.meyman.R
import com.example.meyman.data.remote.preferences.PreferenceHelper
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentDashboardBinding
import com.example.meyman.presentation.ui.screens.home.HomeFragment
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class DashboardFragment : BottomSheetDialogFragment() {

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    private lateinit var binding: FragmentDashboardBinding


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDashboardBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
    }

    @SuppressLint("ResourceType")
    private fun initialize() = with(binding) {
        var roomNum = 1
        var adultNum = 1
        var childNum = 0

        ivRoomPlus.setOnClickListener {
            roomNum++
            tvRoomNum.text = roomNum.toString()
        }

        ivMinusRoom.setOnClickListener {
            if (roomNum <= 0) {
                Toast.makeText(requireActivity(), "Сan't be less", Toast.LENGTH_SHORT).show()
            } else {
                roomNum--
                tvRoomNum.text = roomNum.toString()
            }
        }

        ivAdultPlus.setOnClickListener {
            adultNum++
            tvAdultNum.text = adultNum.toString()
        }

        ivMinusAdult.setOnClickListener {
            if (adultNum <= 0) {
                Toast.makeText(requireActivity(), "Сan't be less", Toast.LENGTH_SHORT).show()
            } else {
                adultNum--
                tvRoomNum.text = adultNum.toString()
            }
        }

        ivChildPlus.setOnClickListener {
            childNum++
            tvChildNum.text = childNum.toString()
        }

        ivMinusChild.setOnClickListener {
            if (childNum < 0) {
                Toast.makeText(requireActivity(), "Сan't be less", Toast.LENGTH_SHORT).show()
            } else {
                childNum--
                tvRoomNum.text = childNum.toString()
            }
        }
        btnApply.setOnClickListener {
            userPreferencesData.apply {
                children = childNum
                adults = adultNum
            }
            Log.e("erbol", "prefs: " + userPreferencesData.children )

            val bundle = Bundle()
            bundle.putString("room", tvRoomNum.text.toString())
            bundle.putString("adult", tvAdultNum.toString())
            bundle.putString("child", tvChildNum.toString())
            findNavController().navigate(R.id.homeFragment, bundle)
            dismiss()
        }
    }
}