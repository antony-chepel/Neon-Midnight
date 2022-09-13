package com.pnixgames.whiteneon

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.pnixgames.R

class ResultHeartActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_heart)
        val b = findViewById<Button>(R.id.b_try)
        b.setOnClickListener {
            startActivity(Intent(this,HeartMainScreen :: class.java))
        }
    }
}