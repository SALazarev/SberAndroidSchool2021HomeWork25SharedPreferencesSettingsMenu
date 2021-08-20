package com.salazarev.hw25sharedpreferencessettingsmenu

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class SecondPrefFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.fragment_pref_screen_2, rootKey)
    }
}