package com.example.scroller

import android.content.Intent
import android.os.Bundle
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.CheckBox
import android.widget.RadioButton
import com.example.scroller.databinding.ActivityScrollingBinding
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

class ScrollingActivity : AppCompatActivity() {

    private lateinit var binding: ActivityScrollingBinding
    private var dolphin: Int = 0
    private var desmume: Int = 0
    private var kegaFusion: Int = 0
    private var mame: Int = 0
    private var mednafen: Int = 0
    private var mesen: Int = 0
    private var openEmu: Int = 0
    private var retroArch: Int = 0
    private var pcsx2: Int = 0
    private var ppsspp: Int = 0
    private var mupen: Int = 0
    private var redream: Int = 0
    private var retroPie: Int = 0
    private var snes9x: Int = 0
    private var visualBoy: Int = 0
    private var nso: Int = 0
    private var nesClassic: Int = 0
    private var snesClassic: Int = 0
    private var psClassic: Int = 0
    private var xboxOne: Int = 0
    private var cemu: Int = 0
    private var ps4: Int = 0

    private var answer1: Int = 0
    private var answer2: Int = 0
    private var answer3: Int = 0
    private var answer4: Int = 0
    private var answer5: Int = 0
    private var answer6: Int = 0
    private var statement1: Int = 0
    private var statement2: Int = 0
    private var statement3: Int = 0
    private var statement4: Int = 0
    private var statement5: Int = 0
    private var statement6: Int = 0

    private var bwindows: Boolean = false
    private var bmac: Boolean = false
    private var blinux: Boolean = false
    private var bandroid: Boolean = false
    private var bios: Boolean = false
    private var bswitch: Boolean = false
    private var bxbox: Boolean = false
    private var bps4: Boolean = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

     binding = ActivityScrollingBinding.inflate(layoutInflater)
     setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbar))
        binding.toolbarLayout.title = title



    }
    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_scrolling, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.

        return when (item.itemId) {
            R.id.action_settings -> true
            else -> super.onOptionsItemSelected(item)
        }
    }

    fun rgHandlerOne(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rg1Button1 ->
                    if (checked) {

                    }
                R.id.rg1Button2 ->
                    if (checked) { //windows, macOS, linux ++
                        answer1 = 2
                    }
                R.id.rg1Button3 ->
                    if (checked) { //android, ios ++
                        answer1 = 3
                    }
                R.id.rg1Button4 ->
                    if (checked) { //all but dedicated ++
                        answer1 = 4

                    }
            }
        }
    }


    //Price range
    fun rgHandlerTwo(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rg2Button1 ->
                    if (checked) {
                        answer2 = 1
                    }
                R.id.rg2Button2 ->
                    if (checked) {
                        answer2 = 2
                    }
                R.id.rg2Button3 ->
                    if (checked) {
                        answer2 = 3
                    }
                R.id.rg2Button4 ->
                    if (checked) {
                        answer2 = 4
                    }
                R.id.rg2Button5 ->
                    if (checked) {
                        answer2 = 5
                    }
                R.id.rg2Button6 ->
                    if (checked) {
                        answer2 = 6
                    }
                R.id.rg2Button7 ->
                    if (checked) {
                        answer2 = 7
                    }
            }
        }
    }



    /*
    //Price limit
    fun rgHandlerThree(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rg3Button1 ->
                    if (checked) {

                    }
                R.id.rg3Button2 ->
                    if (checked) {

                    }
                R.id.rg3Button3 ->
                    if (checked) {

                    }
            }
        }
    }

     */

    //Question 4
    fun checkboxHandlerOne(view: View?) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked

            when (view.id) {
                R.id.cg1checkBox1 -> { //NES
                    if (checked) {
                        mednafen++
                        mesen++
                        openEmu++
                        retroArch++
                        retroPie++
                        nso++
                        nesClassic++
                    } else {
                        mednafen--
                        mesen--
                        openEmu--
                        retroArch--
                        retroPie--
                        nso--
                        nesClassic--
                    }
                }
                R.id.cg1checkBox2 -> { //SNES
                    if (checked) {
                        mednafen++
                        openEmu++
                        retroArch++
                        retroPie++
                        nso++
                        snes9x++
                        snesClassic++
                    } else {
                        mednafen--
                        openEmu--
                        retroArch--
                        retroPie--
                        nso--
                        snes9x--
                        snesClassic--
                    }
                }
                R.id.cg1checkBox3 -> { //N64
                    if (checked) {
                        openEmu++
                        retroArch++
                        mupen++
                        retroPie++
                        nso++
                    } else {
                        openEmu--
                        retroArch--
                        mupen--
                        retroPie--
                        nso--
                    }
                }
                R.id.cg1checkBox4 -> { //GameCube
                    if (checked) {
                        dolphin++
                        openEmu++
                        retroArch++
                        retroPie++
                    } else {
                        dolphin--
                        openEmu--
                        retroArch--
                        retroPie--
                    }
                }
                R.id.cg1checkBox5 -> { //GB/GBC/GBA
                    if (checked) {
                        dolphin++
                        retroArch++
                        retroPie++
                    } else {
                        dolphin--
                        retroArch--
                        retroPie--
                    }
                }
                R.id.cg1checkBox6 -> { //GB/GBC/GBA
                    if (checked) {
                        mednafen++
                        openEmu++
                        retroArch++
                        retroPie++
                        visualBoy++
                    } else {
                        mednafen--
                        openEmu--
                        retroArch--
                        retroPie--
                        visualBoy--
                    }
                }
                R.id.cg1checkBox7 -> { //DS
                    if (checked) {
                        desmume++
                        openEmu++
                        retroArch++
                        retroPie++
                    } else {
                        desmume--
                        openEmu--
                        retroArch--
                        retroPie--
                    }
                }
                R.id.cg1checkBox8 -> { //3DS
                    if (checked) {
                        retroArch++
                    } else {
                        retroArch--
                    }
                }
                R.id.cg1checkBox9 -> { //PS1
                    if (checked) {
                        mednafen++
                        openEmu++
                        retroArch++
                        retroPie++
                        psClassic++
                        ps4++
                    } else {
                        mednafen--
                        openEmu--
                        retroArch--
                        retroPie--
                        psClassic--
                        ps4
                    }
                }
                R.id.cg1checkBox10 -> { //PS2
                    if (checked) {
                        retroArch++
                        pcsx2++
                        retroPie++
                        ps4++
                    } else {
                        retroArch--
                        pcsx2--
                        retroPie--
                        ps4--
                    }
                }
                R.id.cg1checkBox11 -> { //PSP
                    if (checked) {
                        openEmu++
                        retroArch++
                        retroPie++
                        ppsspp++
                    } else {
                        openEmu--
                        retroArch--
                        retroPie--
                        ppsspp--
                    }
                }
                R.id.cg1checkBox12 -> { //xbox
                    if (checked) {
                        xboxOne++
                    } else {
                        xboxOne--
                    }
                }
                R.id.cg1checkBox13 -> { //sega
                    if (checked) {
                        kegaFusion++
                        mednafen++
                        openEmu++
                        retroArch++
                        retroPie++
                        nso++
                    } else {
                        kegaFusion--
                        mednafen--
                        openEmu--
                        retroArch--
                        retroPie--
                        nso--
                    }
                }
                R.id.cg1checkBox14 -> { //atari
                    if (checked) {
                        openEmu++
                        retroArch++
                        retroPie++
                        mame++
                    } else {
                        openEmu--
                        retroArch--
                        retroPie--
                        mame--
                    }
                }
                R.id.cg1checkBox15 -> { //arcade
                    if (checked) {
                        mame++
                    } else {
                        mame--
                    }
                }
            }
        }
    }

    fun checkboxHandlerTwo(view: View?) {
        if (view is CheckBox) {
            val checked: Boolean = view.isChecked
            when (view.id) {
                R.id.cg2checkBox1 -> { //windows
                    if (checked) {
                        incWindows()
                        bwindows = true
                    } else {
                        decWindows()
                        bwindows = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox2 -> { //mac
                    if (checked) {
                        incMac()
                        bmac = true
                    } else {
                        decMac()
                        bmac = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox3 -> { //linux
                    if (checked) {
                        incLinux()
                        blinux = true
                    } else {
                        decLinux()
                        blinux = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox4 -> { //android
                    if (checked) {
                        incAndroid()
                        bandroid = true
                    } else {
                        decAndroid()
                        bandroid = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox5 -> { //ios
                    if (checked) {
                        incIOS()
                        bios = true
                    } else {
                        decIOS()
                        bios = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox6 -> { //nintendo switch
                    if (checked) {
                        nso++
                        bswitch = true
                    } else {
                        nso--
                        bswitch = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox7 -> { //xbox
                    if (checked) {
                        xboxOne++
                        bxbox = true
                    } else {
                        xboxOne--
                        bxbox = false
                    }
                }
            }
            when (view.id) {
                R.id.cg2checkBox8 -> { //ps
                    if (checked) {
                        ps4++
                        bps4 = true
                    } else {
                        ps4--
                        bps4 = false
                    }
                }
            }
        }

    }


    //Question 6
    fun rgHandlerFour(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rg4Button1 ->
                    if (checked) { //windows
                        answer6 = 1
                    }
                R.id.rg4Button2 ->
                    if (checked) { //mac
                        answer6 = 2
                    }
                R.id.rg4Button3 ->
                    if (checked) { //linux
                        answer6 = 3
                    }
                R.id.rg4Button4 ->
                    if (checked) { //android
                        answer6 = 4
                    }
                R.id.rg4Button5 ->
                    if (checked) { //ios
                        answer6 = 5
                    }
                R.id.rg4Button6 ->
                    if (checked) { //console
                        answer6 = 6
                    }
            }
        }
    }


    //Expandable library
    fun statementHandlerOne(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rgs1Button1 -> //strongly disagree
                    if (checked) {
                        statement1 = 1
                    }
                R.id.rgs1Button4 ->
                    if (checked) {
                        statement1 = 4
                    }
                R.id.rgs1Button5 -> //strongly agree
                    if (checked) {
                        statement1 = 5
                    }
            }
        }
    }

    //Authentic input
    fun statementHandlerTwo(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {

                R.id.rgs2Button4 -> //agree
                    if (checked) {
                        statement2 = 4
                    }
                R.id.rgs2Button5 ->
                    if (checked) {
                        statement2 = 5
                    }
            }
        }
    }

    //Mobile
    fun statementHandlerThree(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rgs3Button1 ->
                    if (checked) {
                        statement3 = 1
                    }
                R.id.rgs3Button4 ->
                    if (checked) {
                        statement3 = 4
                    }
                R.id.rgs3Button5 ->
                    if (checked) {
                        statement3 = 5
                    }
            }
        }
    }

    //Legality
    fun statementHandlerFour(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rgs4Button4 ->
                    if (checked) {
                        statement4 = 4
                    }
                R.id.rgs4Button5 ->
                    if (checked) {
                        statement4 = 5
                    }
            }
        }
    }

    //Pre-loaded library
    fun statementHandlerFive(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rgs5Button1 ->
                    if (checked) {
                        statement5 = 1
                    }
                R.id.rgs5Button2 ->
                    if (checked) {
                        statement5 = 2
                    }
                R.id.rgs5Button4 ->
                    if (checked) {
                        statement5 = 4
                    }
                R.id.rgs5Button5 ->
                    if (checked) {
                        statement5 = 5
                    }
            }
        }
    }

    //Ease of use
    fun statementHandlerSix(view: View?) {
        if (view is RadioButton) {
            // Is the button now checked?
            val checked = view.isChecked

            // Check which radio button was clicked
            when (view.getId()) {
                R.id.rgs5Button1 ->
                    if (checked) {
                        statement6 = 1
                    }
                R.id.rgs5Button2 ->
                    if (checked) {

                    }
                R.id.rgs5Button4 ->
                    if (checked) {
                        statement6 = 4
                    }
                R.id.rgs5Button5 ->
                    if (checked) {
                        statement6 = 5
                    }
            }
        }
    }

    fun submitButtonHandler(view: View?) {
        val contextView = findViewById<View>(R.id.buttonSubmit)
        output()

        val sortedValues = mutableListOf(dolphin to "Dolphin", desmume to "DeSmuME",
            kegaFusion to "Kega Fusion", mame to "MAME", mednafen to "Mednafen", mesen to "Mesen",
            openEmu to "OpenEmu", retroArch to "RetroArch", pcsx2 to "PCSX2", ppsspp to "PPSSPP",
            mupen to "Mupen64Plus", redream to "redream", retroPie to "RetroPie",
            snes9x to "Snes9x", visualBoy to "VisualBoyAdvance", nso to "Nintendo Switch Online",
            nesClassic to "NES Classic", snesClassic to "SNES Classic",
            psClassic to "PlayStation Classic", xboxOne to "Xbox One", cemu to "Cemu",
            ps4 to "PlayStation 4")
        sortedValues.sortBy { it.first }
        println(sortedValues)
        val s = sortedValues.asReversed()
        val answer = s.elementAt(0).second

        Snackbar.make(contextView, answer, Snackbar.LENGTH_LONG).show()
        val output = chooseActivity(answer)
        val intent = Intent(this, output)
        //val intent = Intent(this, CemuActivity::class.java)

        startActivity(intent)
    }

    val chooseActivity = { emulator: String ->
        when (emulator) {
            "Dolphin" -> DolphinActivity::class.java
            "DeSmuME" -> Desmume::class.java
            "Kega Fusion" -> KegaActivity::class.java
            "MAME" -> MAME_Activity::class.java
            "Mednafen" -> MednafenActivity::class.java
            "Mesen" -> MesenActivity::class.java
            "OpenEmu" -> OpenEmuActivity::class.java
            "RetroArch" -> RetroArchActivity::class.java
            "PCSX2" -> PCSX2_Activity::class.java
            "PPSSPP" -> PPSSPP::class.java
            "Mupen64Plus" -> MupenActivity::class.java
            "redream" -> RedreamActivity::class.java
            "RetroPie" -> RetroPieActivity::class.java
            "Snes9x" -> SNES9X::class.java
            "VisualBoyAdvance" -> VisualBoyActivity::class.java
            "Nintendo Switch Online" -> NSO_Activity::class.java
            "NES Classic" -> NESCLassicActivity::class.java
            "SNES Classic" -> SNESClassicActivity::class.java
            "PlayStation Classic" -> PSClassicActivity::class.java
            "Xbox One" -> XboxActivity::class.java
            "Cemu" -> CemuActivity::class.java
            "PlayStation 4" -> PS4Activity::class.java
            else -> RetroArchActivity::class.java
        }
    }

    fun output() {
        questionOne()
        questionTwo()
        questionSix()
        statementOne()
        statementTwo()
        statementThree()
        statementFour()
        statementFive()
        statementSix()
    }



    fun questionOne() {
        when (answer1) {
            2 -> {
                incWindows()
                openEmu++
            }
            3 -> {
                incAndroid()
            }
            4 -> {
                incWindows()
                openEmu++
            }
        }
    }

    /*
    fun questionTwo() {
        when (answer1) {
            2 -> {
                incWindows()
                openEmu++
            }
            3 -> {
                incAndroid()
            }
            4 -> {
                incWindows()
                openEmu++
            }
        }
    }

     */

    //Combines with question 5 (second checkboxes)
    fun questionTwo() {
        when (answer2) {
            1 -> { //0-9.99
                val int = 5
                nso -= int
                ps4 -= int
                nesClassic -= int
                snesClassic -= int
                psClassic -= int
                retroPie -= int
                questionTwoHelper(int)
            }
            2 -> { //10-29.99
                val int = 5
                nesClassic -= int
                snesClassic -= int
                psClassic -= int
                retroPie -= int
                questionTwoHelper(int)
            }
            3 -> { //30-49.99
                val int = 5
                nesClassic -= int
                snesClassic -= int
                psClassic -= int
                questionTwoHelper(int)
            }
            4 -> { //50-99.99
                val int = 5
                questionTwoHelper(int)
                /*
                Don't want Android options to be reduced here
                 */
                if (!bandroid) {
                    repeat(int) {
                        incAndroid()
                    }
                }
            }
            5 -> { //100-199.99
                val int = 5
                if (!bmac) {
                    openEmu -= int
                }
                if (!bswitch) {
                    nso -= 5
                }
            }
            6 -> { //200-399.99
                val int = 5
                if (!bmac) {
                    openEmu -= int
                }
            }
            7 -> { //400+

            }
        }
    }

    fun questionTwoHelper(int: Int) {
        if (bmac) {
            if (bwindows) {
                //do nothing
            } else if (blinux) {
                cemu -= int
            } else if (bandroid) {
                mednafen -= int
                mesen -= int
                cemu -= int
            } else {
                repeat(int) {
                    decWindows()
                    incMac()
                }

                openEmu -= int
            }

        } else if (bwindows) {
            openEmu -= int
        } else if (blinux) {
            repeat(int) {
                decWindows()
                incLinux()
            }
            openEmu -= int
        } else if (bandroid) {
            repeat(int) {
                decWindows()
                incAndroid()
            }
            openEmu -= int
        } else if (bios) {
            repeat(int) {
                decWindows()
                incIOS()
            }
            openEmu -= int
        } else {
            repeat(int) {
                decWindows()
                openEmu--
            }
        }
        if (!bswitch) {
            nso -= int
        }
        if (!bxbox) {
            xboxOne -= int
        }
        if (!bps4) {
            ps4 -= int
        }
    }

    fun questionSix() {
        when (answer6) {
            1 -> incWindows()
            2 -> incMac()
            3 -> incLinux()
            4 -> incAndroid()
            5 -> incIOS()
            6 -> {
                nso++
                nesClassic++
                snesClassic++
                psClassic++
                xboxOne++
                ps4++
            }
        }
    }

    fun statementOne() {
        when (statement1) {
            1 -> {
                nso++
                nesClassic++
                snesClassic++
                psClassic++
                ps4++
            }
            4 -> {
                nso--
                nesClassic--
                snesClassic--
                psClassic--
                ps4--
            }
            5 -> {
                nso -= 2
                nesClassic -= 2
                snesClassic -= 2
                psClassic -= 2
                ps4 -= 2
            }
        }
    }

    fun statementTwo() {
        when (statement2) {
            4 -> {
                nso++
                nesClassic++
                snesClassic++
                psClassic++
                xboxOne++
                ps4++
            }
            5 -> {
                nso += 2
                nesClassic += 2
                snesClassic += 2
                psClassic += 2
                xboxOne += 2
                ps4 += 2
            }
        }
    }

    fun statementThree() {
        when (statement3) {
            1 -> decAndroid()
            4 -> incAndroid()
            5 -> {
                incAndroid()
                incAndroid()
            }
        }
    }

    fun statementFour() {
        when (statement4) {
            4 -> {
                nso += 4
                nesClassic += 4
                snesClassic += 4
                psClassic += 4
                xboxOne += 4
                ps4 += 4
            }
            5 -> {
                nso += 10
                nesClassic += 10
                snesClassic += 10
                psClassic += 10
                xboxOne += 10
                ps4 += 10
            }
        }
    }

    fun statementFive() {
        when (statement5) {
            1 -> {
                incWindows()
                incWindows()
                cemu += 2
            }
            2 -> {
                incWindows()
                cemu++
            }
            4 -> {
                nso++
                nesClassic++
                snesClassic++
                psClassic++
                ps4++
            }
            5 -> {
                nso += 2
                nesClassic += 2
                snesClassic += 2
                psClassic += 2
                ps4 += 2
            }
        }
    }

    fun statementSix() {
        when (statement6) {
            1 -> {
                retroArch++
                mednafen++
                mame++
                retroPie++
            }
            2 -> {

            }
            4 -> {
                retroArch--
                mednafen--
                mame--
                retroPie--
            }
            5 -> {
                retroArch -= 2
                mednafen -= 2
                mame -= 2
                retroPie -= 2
            }
        }
    }

    fun incWindows() {
        dolphin++
        desmume++
        kegaFusion++
        mame++
        mednafen++
        mesen++
        retroArch++
        pcsx2++
        ppsspp++
        mupen++
        redream++
        snes9x++
        visualBoy++
        cemu++
    }

    fun decWindows() {
        dolphin--
        desmume--
        kegaFusion--
        mame--
        mednafen--
        mesen--
        retroArch--
        pcsx2--
        ppsspp--
        mupen--
        redream--
        snes9x--
        visualBoy--
        cemu--
    }

    fun incMac() {
        dolphin++
        openEmu++
        kegaFusion++
        mame++
        retroArch++
        pcsx2++
        ppsspp++
        mupen++
        redream++
        snes9x++
        visualBoy++
    }

    fun decMac() {
        dolphin--
        openEmu--
        kegaFusion--
        mame--
        retroArch--
        pcsx2--
        ppsspp--
        mupen--
        redream--
        snes9x--
        visualBoy--
    }

    fun incLinux() {
        dolphin++
        desmume++
        kegaFusion++
        mame++
        mednafen++
        mesen++
        retroArch++
        pcsx2++
        ppsspp++
        mupen++
        redream++
        snes9x++
        visualBoy++
    }

    fun decLinux() {
        dolphin--
        desmume--
        kegaFusion--
        mame--
        mednafen--
        mesen--
        retroArch--
        pcsx2--
        ppsspp--
        mupen--
        redream--
        snes9x--
        visualBoy--
    }

    fun incAndroid() {
        dolphin++
        desmume++
        retroArch++
        ppsspp++
        mupen++
        redream++
        snes9x++
    }

    fun decAndroid() {
        dolphin--
        desmume--
        retroArch--
        ppsspp--
        mupen--
        redream--
        snes9x--
    }

    fun incIOS() {
        retroArch++
        ppsspp++
    }

    fun decIOS() {
        retroArch--
        ppsspp--
    }

}