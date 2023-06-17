package com.example.magtymgyly_pragy

import android.os.Bundle
import android.text.method.ScrollingMovementMethod
import android.widget.TextView
import com.akexorcist.localizationactivity.ui.LocalizationActivity

class Gurgenin : LocalizationActivity() {

    // Declaring TextView from the Layout
    private lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gule_menzeyar)

        // initializing the TextView
        textview = findViewById(R.id.text)

        textview.text = getString(R.string.gule_menzeyar)


        // to perform the movement action
        // Moves the cursor or scrolls to the
        // top or bottom of the document
        textview.movementMethod = ScrollingMovementMethod()


    }
}


// Creating a string that contains the information to be displayed
val para = """                       Gurgenin
            
  Öňünde belent dag, serinde duman,
  Deňizden öwüser ýeli Gürgeniň;
  Bulut oýnap, baran dolsa çaýlara,
  Akar boz bulanyp sili Gürgeniň.
  
  Tokaýlary bardyr gargy-gamyşly,
  Gözelleri bardyr altyn-kümüşli
  Boz güsbent, gyr ýylky, gara gäwmişli,
  Argaly gäw bolar maly Gürgeniň.
  
  Hatarlanyp duran iner, maýalar,
  Agyr bezirgenler, tuçjar eýeler,
  Seňrikläp, abanyp duran gaýalar,
  Öňi-ardy sagy-soly Gürgeniň.
  
  Ýigitler tirme-şal guşar biline,
  Ýorga münüp, tarlaň alar eline,
  Ak göwsün biýr jeren deňiz ýeline,
  Mäleýir maraly çöli Gürgeniň.
  
  Magtymguly ilden-ile aralar,
  Hijran tygy bilen bagryn paralar,
  Golun sallap maral gabak periler,
  Iner ol umyndan däli Gurgeniň.
                
                """

// set value to the given TextView
//        textview.text = para
