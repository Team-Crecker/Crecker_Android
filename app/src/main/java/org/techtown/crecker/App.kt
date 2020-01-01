package org.techtown.crecker

import android.app.Application
import android.content.Context
import com.amn.easysharedpreferences.EasySharedPreferenceConfig

class App : Application() {
    override fun onCreate() {
        super.onCreate()
        EasySharedPreferenceConfig.initDefault(EasySharedPreferenceConfig.Builder().inputFileName("easy_preference") .inputMode(
            Context.MODE_PRIVATE) .build())
    }
}
