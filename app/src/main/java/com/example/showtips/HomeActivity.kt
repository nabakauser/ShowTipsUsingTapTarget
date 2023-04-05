package com.example.showtips

import android.content.SharedPreferences
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.showtips.databinding.ActivityMainBinding
import com.getkeepsafe.taptargetview.TapTarget
import com.getkeepsafe.taptargetview.TapTargetView

class HomeActivity : AppCompatActivity() {
    private var binding: ActivityMainBinding? = null
    private var isSelected: Boolean = false
    private lateinit var sharedPreferences: SharedPreferences
    private lateinit var editor: SharedPreferences.Editor
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        sharedPreferences = getSharedPreferences("KEY", MODE_PRIVATE)
        editor = sharedPreferences.edit()
        setUpTipsFragment()
        showTitleTips()
    }

    private fun setUpTipsFragment() {
        val tipsFragment = TipsFragment()
        val frameLayout = R.id.frameLayout
        binding?.uiIvInfo?.setOnClickListener {
            isSelected = !isSelected
            if (isSelected) {
                supportFragmentManager
                    .beginTransaction()
                    .apply {
                        replace(frameLayout, tipsFragment)
                        commit()
                    }
            }
            if (!isSelected) {
                supportFragmentManager
                    .beginTransaction()
                    .apply {
                        remove(tipsFragment)
                        commit()
                    }
            }
        }
    }

    private fun showTitleTips() {
        if(!sharedPreferences.getBoolean("KEY", false)) {
            TapTargetView.showFor(this,TapTarget.forView(
                binding?.uiTvTitle,
                "Title",
                "This is the title"
            )
                .tintTarget(false)
                .outerCircleColor(R.color.black)
                .outerCircleAlpha(.7f)
                .targetCircleColor(R.color.grey)
                .textColor(R.color.white)
                .titleTextSize(18)
                .descriptionTextSize(14)
                .textTypeface(Typeface.SERIF)
                .dimColor(R.color.black)
                .cancelable(false),
                object : TapTargetView.Listener() {
                    override fun onTargetClick(view: TapTargetView?) {
                        super.onTargetClick(view)
                        showInfoTips()
                    }
                }
            )
        }
    }

    private fun showInfoTips() {
        TapTargetView.showFor(this,TapTarget.forView(
            binding?.uiIvInfo,
            "Info",
            "Click info to learn about how face capture authentication works"
        )
            .tintTarget(false)
            .outerCircleColor(R.color.black)
            .outerCircleAlpha(.7f)
            .targetCircleColor(R.color.grey)
            .textColor(R.color.white)
            .titleTextSize(18)
            .descriptionTextSize(14)
            .textTypeface(Typeface.SERIF)
            .dimColor(R.color.black)
            .cancelable(false),
            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView?) {
                    super.onTargetClick(view)
                    showButtonTips()
                }
            }
        )
    }

    private fun showButtonTips() {
        TapTargetView.showFor(this,TapTarget.forView(
            binding?.uiBtnOne,
            "Button One",
            "This button does nothing"
        )
            .tintTarget(false)
            .outerCircleColor(R.color.black)
            .outerCircleAlpha(.7f)
            .targetCircleColor(R.color.grey)
            .textColor(R.color.white)
            .titleTextSize(18)
            .descriptionTextSize(14)
            .textTypeface(Typeface.SERIF)
            .dimColor(R.color.black)
            .cancelable(false),
            object : TapTargetView.Listener() {
                override fun onTargetClick(view: TapTargetView?) {
                    super.onTargetClick(view)
                    editor.putBoolean("KEY", false)
                    editor.apply()
                }
            }
        )
    }
}