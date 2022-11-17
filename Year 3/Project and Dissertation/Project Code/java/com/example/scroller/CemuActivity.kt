package com.example.scroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.LinkMovementMethod
import android.view.View
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar

class CemuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cemu)

    }

    fun optionsButtonHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, OptionsActivity::class.java)
        startActivity(intent)
    }

    fun backButtonHandler(view: View?) {
        finish()
    }

}