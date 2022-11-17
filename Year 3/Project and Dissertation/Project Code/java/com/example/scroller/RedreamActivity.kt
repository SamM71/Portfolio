package com.example.scroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class RedreamActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_redream)
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