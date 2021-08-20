package com.salazarev.hw25sharedpreferencessettingsmenu

import android.os.Bundle
import androidx.preference.Preference
import androidx.preference.PreferenceFragmentCompat

class PreferencesFragment : PreferenceFragmentCompat(),
    PreferenceFragmentCompat.OnPreferenceStartFragmentCallback {

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        setPreferencesFromResource(R.xml.fragment_pref_screen, rootKey)
    }

    override fun onPreferenceStartFragment(
        caller: PreferenceFragmentCompat,
        pref: Preference
    ): Boolean {
        requireActivity().supportFragmentManager.beginTransaction()
            .replace(R.id.container_settings, SecondPrefFragment())
            .addToBackStack(null)
            .commit()
        return true
    }
}