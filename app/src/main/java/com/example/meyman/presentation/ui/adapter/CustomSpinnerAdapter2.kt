package com.example.meyman.presentation.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import com.example.meyman.presentation.ui.screens.spinerhome.SpinnerItem2
import com.example.meyman.R

class CustomSpinnerAdapter2(
    context: Context,
    private val resource: Int,
    private val items: List<SpinnerItem2>
) : ArrayAdapter<SpinnerItem2>(context, resource, items) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    override fun getDropDownView(position: Int, convertView: View?, parent: ViewGroup): View {
        return getCustomView(position, convertView, parent)
    }

    private fun getCustomView(position: Int, convertView: View?, parent: ViewGroup): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(resource, parent, false)
        val iconImageView = view.findViewById<ImageView>(R.id.currensy1)
        val textView = view.findViewById<TextView>(R.id.text_spinner2)

        val item = items[position]
        iconImageView.setImageResource(item.iconResId)
        textView.text = item.text

        return view
    }
}