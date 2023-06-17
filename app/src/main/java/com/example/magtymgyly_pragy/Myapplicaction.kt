package com.example.magtymgyly_pragy

import android.content.Context
import com.akexorcist.localizationactivity.ui.LocalizationApplication
import java.util.Locale

class Myapplicaction : LocalizationApplication() {
    override fun getDefaultLanguage(context: Context): Locale {
          return Locale.ENGLISH
    }
}