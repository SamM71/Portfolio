package com.example.scroller

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View

class OptionsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_options)
    }

    fun cemuHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, CemuActivity::class.java)
        startActivity(intent)
    }

    fun desmumeHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, Desmume::class.java)
        startActivity(intent)
    }

    fun dolphinHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, DolphinActivity::class.java)
        startActivity(intent)
    }

    fun kegaHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, KegaActivity::class.java)
        startActivity(intent)
    }

    fun mameHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, MAME_Activity::class.java)
        startActivity(intent)
    }

    fun mednafenHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, MednafenActivity::class.java)
        startActivity(intent)
    }

    fun mesenHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, MesenActivity::class.java)
        startActivity(intent)
    }

    fun mupenHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, MupenActivity::class.java)
        startActivity(intent)
    }

    fun nesClassicHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, NESCLassicActivity::class.java)
        startActivity(intent)
    }

    fun nsoHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, NSO_Activity::class.java)
        startActivity(intent)
    }

    fun openEmuHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, OpenEmuActivity::class.java)
        startActivity(intent)
    }

    fun pcsx2Handler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, PCSX2_Activity::class.java)
        startActivity(intent)
    }

    fun ppssppHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, PPSSPP::class.java)
        startActivity(intent)
    }

    fun ps4Handler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, PS4Activity::class.java)
        startActivity(intent)
    }

    fun psClassicHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, PSClassicActivity::class.java)
        startActivity(intent)
    }

    fun redreamHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, RedreamActivity::class.java)
        startActivity(intent)
    }

    fun retroArchHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, RetroArchActivity::class.java)
        startActivity(intent)
    }

    fun retroPieHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, RetroArchActivity::class.java)
        startActivity(intent)
    }

    fun snes9xHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, SNES9X::class.java)
        startActivity(intent)
    }

    fun snesClassicHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, SNESClassicActivity::class.java)
        startActivity(intent)
    }

    fun visualBoyHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, VisualBoyActivity::class.java)
        startActivity(intent)
    }

    fun xboxHandler(view: View?) {
        val contextView = findViewById<View>(R.id.button)
        val intent = Intent(this, XboxActivity::class.java)
        startActivity(intent)
    }

    fun backHandler(view: View?) {
        finish()
    }

}