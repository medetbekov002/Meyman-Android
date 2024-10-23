package com.example.meyman.presentation.ui.screens.room_page.booking

import android.graphics.Rect
import android.os.Bundle
import android.os.Handler
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.WindowManager
import android.widget.EditText
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.FragmentRoomBookingBinding
import com.example.meyman.domain.utils.models.reservation.ReservationPostModel
import com.example.meyman.presentation.state.UIState
import com.google.android.material.textfield.TextInputLayout
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class RoomBookingFragment ():
    BaseFragment<FragmentRoomBookingBinding, RoomBookingViewModel>(R.layout.fragment_room_booking) {


    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper
    override val binding: FragmentRoomBookingBinding by viewBinding(FragmentRoomBookingBinding::bind)
    override val viewModel: RoomBookingViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_room_booking, container, false)
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
        binding.tvHotelName.text = userPreferencesData.housingName
        binding.tvLocation.text = userPreferencesData.adress

    }

    private fun initListener() {

        binding.btnReserve.setOnClickListener {

            val username = binding.etUserName.text.toString().trim()
            val phoneNumber = "${binding.etUserPhoneNumber.text.toString().trim()}"
            val number = binding.etUserPhoneNumber
            val email = binding.etUserEmail.text.toString().trim()
            val emaill = binding.etUserEmail
            val hotelId = userPreferencesData.hotelId

            number.addTextChangedListener(object : TextWatcher {
                override fun beforeTextChanged(
                    s: CharSequence?,
                    start: Int,
                    count: Int,
                    after: Int
                ) {
                }

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}

                override fun afterTextChanged(s: Editable?) {
                    // Проверяем введенный номер
                    val phoneNumber = s.toString()
                    val isValid = validatePhoneNumber(phoneNumber)

                    if (!isValid) {
                        number.error = "Неверный формат номера"
                    }
                }
            })

            viewModel.postReservation(
                "Bearer ${userPreferencesData.accessToken}",
                ReservationPostModel(
                    hotelId, "2023-09-20", "2024-09-20",
                    username, email,
                    phoneNumber, userPreferencesData.adults,
                    userPreferencesData.children
                )
            )

            Log.e("erbol", "edittext: " + username + phoneNumber + email)

            if (!isGmailAddressValid(email)) {
                emaill.error = "Введите корректную почту"
            } else if (!validatePhoneNumber(phoneNumber)) {
                number.error = "Введите корректный номер"
            } else if (binding.etUserName.text?.isEmpty()!!) {
                binding.etUserName.error = "Введите корректное имя"
            } else {
                findNavController().navigate(R.id.action_roomBookingFragment_to_reservationFragment)
                viewLifecycleOwner.lifecycleScope.launch {
                    viewLifecycleOwner.repeatOnLifecycle(Lifecycle.State.CREATED) {
                        viewModel.reservation.collect {
                            when (it) {
                                is UIState.Error -> {
                                    Log.e("erbol", "reservation: " + it.error)
                                }

                                is UIState.Loading -> {
//                                binding.progressBar.isVisible = true
                                }

                                is UIState.Success -> {
                                    Log.e("erbol", "reservation: " + it.data)
                                }
                            }
                        }
                    }
                }
            }

        }

    }

    fun isGmailAddressValid(email: String): Boolean {
        // Используйте регулярное выражение для проверки адреса электронной почты
        val emailPattern = "[a-zA-Z0-9._-]+@gmail.com"
        return email.matches(emailPattern.toRegex())
    }

    private fun validatePhoneNumber(phoneNumber: String): Boolean {
        // Проверяем, что номер начинается с "+996" и имеет 13 символов
        return phoneNumber.startsWith("+996") && phoneNumber.length == 13
    }

}
