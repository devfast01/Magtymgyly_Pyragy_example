package com.example.magtymgyly_pragy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.akexorcist.localizationactivity.ui.LocalizationActivity

class turkmen_binasy : LocalizationActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_turkmen_binasy)

        // Declaring TextView from the Layout

        // initializing the TextView
        var textview: TextView = findViewById(R.id.myhaman)

        // set value to the given TextView
        textview.text = getString(R.string.turkmen_binasy)

        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        textview.movementMethod = ScrollingMovementMethod()

    }
}