package com.salazarev.hw25sharedpreferencessettingsmenu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.preference.PreferenceFragmentCompat
import com.salazarev.hw25sharedpreferencessettingsmenu.databinding.FragmentMainBinding

class PreferencesFragment: PreferenceFragmentCompat() {
    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
       setPreferencesFromResource(R.xml.fragment_pref_screen, rootKey)
    }
}