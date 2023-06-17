package com.example.magtymgyly_pragy

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.ImageButton
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.akexorcist.localizationactivity.ui.LocalizationActivity
import com.example.magtymgyly_pragy.RVOneAdapter.OnItemsClickListener
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : LocalizationActivity() {
    lateinit var btnJapan: ImageButton
    lateinit var btnTurkmen: ImageButton
    lateinit var bottomNav: BottomNavigationView

    // reference for the Main-List RecyclerView
    private var RVOne: RecyclerView? = null

    // Main-list item titles will be stored here
    private var gosgyList: ArrayList<RVOneModel>? = null

    // reference for the RVOneAdapter class
    private var rvOneAdapter: RVOneAdapter? = null

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Linked up with its respective id used in the activity_main.xml
        btnJapan = findViewById(R.id.btnJapan)
        btnTurkmen = findViewById(R.id.btnTurkmen)
        RVOne = findViewById(R.id.recyclerViewOne)


        btnJapan.setOnClickListener {
            setLanguage("ja")
        }
        btnTurkmen.setOnClickListener {
            setLanguage("en")
        }

        // Setting the Main-List RecyclerView horizontally
        RVOne?.run {
            layoutManager =
                LinearLayoutManager(applicationContext, LinearLayoutManager.VERTICAL, false)
        }
        gosgyList = ArrayList()

        // Static data are stored one by one in the tutorialList arrayList
        gosgyList!!.add(RVOneModel("Gule Menzeyar", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Göze myhmandyr", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Türkmeniň", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Turkmen binasy", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Oylengin", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Boylaryna", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Aty gerek", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Gecdi diyip aglaryn", R.drawable.magtymguly))
        gosgyList!!.add(RVOneModel("Gecdi diyip aglaryn", R.drawable.magtymguly))


        // The app will show Algorithms Sub-List every time the activity starts
        rvOneAdapter = RVOneAdapter(gosgyList!!)
        RVOne.run { this!!.adapter = rvOneAdapter }

        // Setting up the events that will occur on each Main-List item click
        rvOneAdapter!!.setWhenClickListener(object : OnItemsClickListener {
            override fun onItemClick(positon: Int) {

                when (positon) {
                    0 -> {
                        val intent = Intent(this@MainActivity, Gurgenin::class.java)
                        startActivity(intent)
                    }
                    1 -> {
                        val intent = Intent(this@MainActivity, goze_myhman::class.java)
                        startActivity(intent)
                    }
                    2 -> {
                        val intent = Intent(this@MainActivity, turkmenin::class.java)
                        startActivity(intent)
                    }
                    3 -> {
                        val intent = Intent(this@MainActivity, turkmen_binasy::class.java)
                        startActivity(intent)
                    }
                    4 -> {
                        val intent = Intent(this@MainActivity, oylengin::class.java)
                        startActivity(intent)
                    }
                    5 -> {
                        val intent = Intent(this@MainActivity, boylaryna::class.java)
                        startActivity(intent)
                    }
                    6 -> {
                        val intent = Intent(this@MainActivity, alty_gerek::class.java)
                        startActivity(intent)
                    }
                    7 -> {
                        val intent = Intent(this@MainActivity, aglaryn::class.java)
                        startActivity(intent)
                    }
                    else -> { // Note the block
                        Toast.makeText(applicationContext, "No CLICK",Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })

        bottomNav = findViewById<BottomNavigationView>(R.id.bottomNav)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.home -> {
                    Toast.makeText(applicationContext, "Gosgylary", Toast.LENGTH_SHORT).show()
//                    startActivity(Intent(this, Activity_players::class.java))
                    true
                }

                R.id.message -> {
                    startActivity(Intent(this, Activity_players::class.java))
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

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId){
            R.id.about -> Toast.makeText(this,"About Selected",Toast.LENGTH_SHORT).show()
            R.id.settings -> Toast.makeText(this,"Settings Selected",Toast.LENGTH_SHORT).show()
            R.id.exit -> Toast.makeText(this,"Exit Selected",Toast.LENGTH_SHORT).show()
        }
        return super.onOptionsItemSelected(item)
    }
}

