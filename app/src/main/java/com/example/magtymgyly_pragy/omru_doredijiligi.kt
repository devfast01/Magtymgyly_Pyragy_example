package com.example.magtymgyly_pragy

import android.content.Intent
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import android.widget.Toast
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class omru_doredijiligi : LocalizationActivity() {
    lateinit var bottomNav : BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.omru_doredijiligi)
        // initializing the TextView
        var textview: TextView = findViewById(R.id.omur_doredijiligi)

        // set value to the given TextView
        textview.text = getString(R.string.omur_doredijiligi)

        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        textview.movementMethod = ScrollingMovementMethod()

        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.message -> {
                    startActivity(Intent(this, Activity_players::class.java))
                    true
                }
                R.id.settings -> {
                    Toast.makeText(applicationContext, "ömri we döredijiligi", Toast.LENGTH_SHORT).show()
                    true
                }
                else -> {
                    true
                }
            }
        }
    }

}