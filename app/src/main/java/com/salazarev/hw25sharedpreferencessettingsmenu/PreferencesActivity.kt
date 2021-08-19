package com.salazarev.hw25sharedpreferencessettingsmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat
import androidx.preference.PreferenceScreen

class PreferencesActivity : AppCompatActivity(), PreferenceFragmentCompat.OnPreferenceStartScreenCallback {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_preferences)

        if (savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings_container, PreferencesFragment())
                .commit()
        }
    }
        override fun onPreferenceStartScreen(
            caller: PreferenceFragmentCompat,
            pref: PreferenceScreen
        ): Boolean {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.settings_container, PreferencesFragment.newInstance(pref.key))
                .addToBackStack(null)
                .commit()
            return true
        }
}