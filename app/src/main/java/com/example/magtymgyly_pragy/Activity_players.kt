package com.example.magtymgyly_pragy

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Activity_players : LocalizationActivity() {
    lateinit var bottomNav : BottomNavigationView

    // reference for the Main-List RecyclerView
    private var soundRecycler: RecyclerView? = null

    // Main-list item titles will be stored here
    private var gosgyList: ArrayList<soundModel>? = null

    // reference for the RVOneAdapter class
    private var soundAdapter: soundAdapter? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_players)

        // Linked up with its respective id used in the activity_main.xml
        soundRecycler = findViewById(R.id.recyclerViewOne)

        // Setting the Main-List RecyclerView horizontally
        soundRecycler?.run { layoutManager = LinearLayoutManager(applicationContext,
            LinearLayoutManager.VERTICAL,false)
        }
        gosgyList = ArrayList()

        // Static data are stored one by one in the tutorialList arrayList
        gosgyList!!.add(soundModel("Gule Menzeyar", R.drawable.play_button))
        gosgyList!!.add(soundModel("Göze myhmandyr", R.drawable.play_button))
        gosgyList!!.add(soundModel("Turkmenin", R.drawable.play_button))
        gosgyList!!.add(soundModel("Turmen binasy", R.drawable.play_button))
        gosgyList!!.add(soundModel("Oylengin", R.drawable.play_button))
        gosgyList!!.add(soundModel("Boylaryna", R.drawable.play_button))
        gosgyList!!.add(soundModel("Aty gerek", R.drawable.play_button))
        gosgyList!!.add(soundModel("Gecdi diyip aglaryn", R.drawable.play_button))
        gosgyList!!.add(soundModel("Gecdi diyip aglaryn", R.drawable.play_button))

        // The app will show Algorithms Sub-List every time the activity starts
        soundAdapter = soundAdapter(gosgyList!!)
        soundRecycler.run { this!!.adapter = soundAdapter }

// Setting up the events that will occur on each Main-List item click
        soundAdapter!!.setWhenClickListener(object : soundAdapter.OnItemsClickListener {
            override fun onItemClick(positon: Int) {
//                val intent = Intent(this@MainActivity, Activity_gosgy::class.java)
//                startActivity(intent)
                when (positon) {
                    0 ->{
                        val intent = Intent(this@Activity_players, gurgenin_Sound::class.java)
                        startActivity(intent)
                    }
                    1 ->{
                        val intent = Intent(this@Activity_players, goze_myhman_sound::class.java)
                        startActivity(intent)
                    }
                    2 ->{
                        val intent = Intent(this@Activity_players, turkmenin_sound::class.java)
                        startActivity(intent)
                    }
                    3 ->{
                        val intent = Intent(this@Activity_players, turkmen_binasy_sound::class.java)
                        startActivity(intent)
                    }
                    4 ->{
                        val intent = Intent(this@Activity_players, oylengin_sound::class.java)
                        startActivity(intent)
                    }
                    5 ->{
                        val intent = Intent(this@Activity_players, boylaryna_sound::class.java)
                        startActivity(intent)
                    }
                    6 ->{
                        val intent = Intent(this@Activity_players, alty_gerek_sound::class.java)
                        startActivity(intent)
                    }
                    7 ->{
                        val intent = Intent(this@Activity_players, aglaryn_sound::class.java)
                        startActivity(intent)
                    }
                    else -> { // Note the block
                        Toast.makeText(this@Activity_players, "no action", Toast.LENGTH_SHORT).show()
                    }
                }

                //Toast.makeText(applicationContext, "Position: $positon",Toast.LENGTH_SHORT).show()
            }
        })



        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    startActivity(Intent(this, MainActivity::class.java))
                    true
                }
                R.id.message -> {
                    Toast.makeText(applicationContext, "Ses yazgylar", Toast.LENGTH_SHORT).show()
                    true
                }
                R.id.settings -> {
                    startActivity(Intent(this, omru_doredijiligi::class.java))
                    true
                }
                else -> {
                    true
                }
            }
        }
    }
}