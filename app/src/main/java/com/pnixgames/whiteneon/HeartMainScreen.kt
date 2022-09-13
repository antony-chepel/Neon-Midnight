package com.pnixgames.whiteneon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.View
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.pnixgames.R
import com.pnixgames.databinding.ActivityHeartMainScreenBinding
import kotlin.system.exitProcess
var hdsfsdfds = true
class HeartMainScreen : AppCompatActivity() {
    private lateinit var binding : ActivityHeartMainScreenBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHeartMainScreenBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button10.setOnClickListener {
            bhsdewe()

        }
    }

    var ywuweqwe = 0
    var bcgchdsd = 0
    fun clickfun(view: View) {
        if (hdsfsdfds) {
            val but = view as ImageView
            var cellID = 0

            when (but.id) {
                R.id.button -> cellID = 1
                R.id.button2 -> cellID = 2
                R.id.button3 -> cellID = 3
                R.id.button4 -> cellID = 4
                R.id.button5 -> cellID = 5
                R.id.button6 -> cellID = 6
                R.id.button7 -> cellID = 7
                R.id.button8 -> cellID = 8
                R.id.button9 -> cellID = 9

            }
            hdsfsdfds = false;
            Handler().postDelayed(Runnable { hdsfsdfds = true }, 600)
            playnow(but, cellID)

        }
    }

    var vdgdas = ArrayList<Int>()
    var bhxhsd = ArrayList<Int>()
    var usisds = ArrayList<Int>()
    var gshsdsw = 1
    fun playnow(buttonSelected: ImageView, currCell: Int) {
        if (gshsdsw == 1) {
            buttonSelected.setImageResource(R.drawable.heart)
            vdgdas.add(currCell)
            usisds.add(currCell)
            buttonSelected.isEnabled = false
            val checkWinner = hsdjdwd()
            if (checkWinner == 1) {
                Handler().postDelayed(Runnable { bhsdewe() }, 2000)
            }

        } else {
            buttonSelected.setImageResource(R.drawable.heart)
            gshsdsw = 1
            bhxhsd.add(currCell)
            usisds.add(currCell)
            buttonSelected.isEnabled = false
            val checkWinner = hsdjdwd()
            if (checkWinner == 1)
                Handler().postDelayed(Runnable { bhsdewe() }, 4000)
        }

    }

    fun hsdjdwd(): Int {
        if ((vdgdas.contains(1) && vdgdas.contains(2) && vdgdas.contains(3)) || (vdgdas.contains(
                1
            ) && vdgdas.contains(4) && vdgdas.contains(7)) ||
            (vdgdas.contains(3) && vdgdas.contains(6) && vdgdas.contains(9)) || (vdgdas.contains(
                7
            ) && vdgdas.contains(8) && vdgdas.contains(9)) ||
            (vdgdas.contains(4) && vdgdas.contains(5) && vdgdas.contains(6)) || (vdgdas.contains(
                1
            ) && vdgdas.contains(5) && vdgdas.contains(9)) ||
            vdgdas.contains(3) && vdgdas.contains(5) && vdgdas.contains(7) || (vdgdas.contains(2) && vdgdas.contains(
                5
            ) && vdgdas.contains(8))
        ) {
            ywuweqwe += 1
            osisdidsd()

            bxhwweqwew()
            startActivity(Intent(this@HeartMainScreen, ResultHeartActivity::class.java))
            return 1


        } else if ((bhxhsd.contains(1) && bhxhsd.contains(2) && bhxhsd.contains(3)) || (bhxhsd.contains(
                1
            ) && bhxhsd.contains(4) && bhxhsd.contains(7)) ||
            (bhxhsd.contains(3) && bhxhsd.contains(6) && bhxhsd.contains(9)) || (bhxhsd.contains(
                7
            ) && bhxhsd.contains(8) && bhxhsd.contains(9)) ||
            (bhxhsd.contains(4) && bhxhsd.contains(5) && bhxhsd.contains(6)) || (bhxhsd.contains(
                1
            ) && bhxhsd.contains(5) && bhxhsd.contains(9)) ||
            bhxhsd.contains(3) && bhxhsd.contains(5) && bhxhsd.contains(7) || (bhxhsd.contains(2) && bhxhsd.contains(
                5
            ) && bhxhsd.contains(8))
        ) {
            bcgchdsd += 1

            osisdidsd()
            bxhwweqwew()

            startActivity(Intent(this@HeartMainScreen, ResultHeartActivity::class.java))
            return 1
        } else if (usisds.contains(1) && usisds.contains(2) && usisds.contains(3) && usisds.contains(
                4
            ) && usisds.contains(5) && usisds.contains(6) && usisds.contains(7) &&
            usisds.contains(8) && usisds.contains(9)
        ) {
             startActivity(Intent(this@HeartMainScreen, ResultHeartActivity::class.java))
            return 1

        }
        return 0
    }

    fun bhsdewe() = with(binding) {
        vdgdas.clear()
        bhxhsd.clear()
        usisds.clear()
        gshsdsw = 1;
        for (i in 1..9) {
            var buttonselected: ImageView?
            buttonselected = when (i) {
                1 -> button
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button
                }
            }
            buttonselected.setImageResource(0)
            buttonselected.isEnabled = true
        }
    }

    fun osisdidsd() =with(binding) {
        for (i in 1..9) {
            val buttonSelected = when (i) {
                1 -> button
                2 -> button2
                3 -> button3
                4 -> button4
                5 -> button5
                6 -> button6
                7 -> button7
                8 -> button8
                9 -> button9
                else -> {
                    button
                }

            }
            if (buttonSelected.isEnabled == true)
                buttonSelected.isEnabled = false
        }
    }

    fun bxhwweqwew() = with(binding) {
        button10.isClickable = false
        button10.alpha = 0.7f

        Handler().postDelayed(Runnable { button10.isClickable = true }, 2200)
        Handler().postDelayed(Runnable { button10.alpha = 1.0f }, 2200)
    }
}