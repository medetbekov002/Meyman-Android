package com.example.meyman.presentation.ui.screens.connect

import android.content.Intent
import android.net.Uri
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.meyman.R
import com.example.meyman.core.base.BaseFragment
import com.example.meyman.databinding.FragmentConnectBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ConnectFragment :
    BaseFragment<FragmentConnectBinding, ConnectViewModel>(R.layout.fragment_connect) {

    override val binding by viewBinding(FragmentConnectBinding::bind)
    override val viewModel: ConnectViewModel by viewModels()

    private val email = "ibragimyusupov531@gmail.com"
    private val whatsappNumber = "+996704042323"
    private val uriTextEmail = "mailto:$email"
    private val uriTextWhatsapp = "https://wa.me/$whatsappNumber"
    private val uriEmail = Uri.parse(uriTextEmail)
    private val uriWhatsapp = Uri.parse(uriTextWhatsapp)


    override fun initialize() {
        super.initialize()
    }

    override fun setupSubscribes() = with(binding) {

        val emileIntent = Intent(Intent.ACTION_SENDTO)
        val whatsappIntent = Intent(Intent.ACTION_VIEW, uriWhatsapp)
        emileIntent.data = uriEmail

        ivBack.setOnClickListener {
            findNavController().navigateUp()
        }

        clEmail.setOnClickListener {
            startActivity(emileIntent)
        }

        clWhatsapp.setOnClickListener {
            startActivity(whatsappIntent)
        }
    }

}