package com.example.showtips

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import com.example.showtips.databinding.FragmentTipsBinding


class TipsFragment : Fragment(R.layout.fragment_tips) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setUpListeners()
    }

    private fun setUpListeners() {
        val uiBtnNext = view?.findViewById<Button>(R.id.uiBtnNext)
        val uiIvImage = view?.findViewById<ImageView>(R.id.uiIvImage)
        val uiTvTipTitle = view?.findViewById<TextView>(R.id.uiTvTipTitle)
        uiBtnNext?.setOnClickListener {
            if (uiBtnNext.text == "Next >>") {
                uiTvTipTitle?.text = "Blink when 'blink' is shown"
                uiIvImage?.setImageResource(R.drawable.blink)
                uiBtnNext.text = "Done"
            } else if (uiBtnNext.text == "Done") {
                parentFragmentManager.beginTransaction().remove(this).commit()
            }
        }
    }
}