package com.khunsma.myanamrbanks.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.khunsma.myanamrbanks.R

open class BaseActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    fun showToast(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        animateFadeInOut()
    }

    override fun onBackPressed() {
        super.onBackPressed()
        animateFadeInOut()
    }

    fun animateFadeInOut() {
        overridePendingTransition(R.anim.anim_fade_in, R.anim.anim_fade_out)
    }

}