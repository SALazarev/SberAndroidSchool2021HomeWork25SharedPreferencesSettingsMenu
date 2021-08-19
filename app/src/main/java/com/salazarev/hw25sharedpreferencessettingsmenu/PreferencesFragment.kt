package com.salazarev.hw25sharedpreferencessettingsmenu

import android.os.Bundle
import androidx.preference.PreferenceFragmentCompat

class PreferencesFragment : PreferenceFragmentCompat() {
    companion object {
        private const val ARG_ROOT = "root"

        fun newInstance(rootKey: String): PreferencesFragment{
            val args = Bundle()
            args.putString(ARG_ROOT,rootKey)
            val fragment =  PreferencesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreatePreferences(savedInstanceState: Bundle?, rootKey: String?) {
        val root = arguments?.getString(ARG_ROOT) ?: rootKey
        setPreferencesFromResource(R.xml.fragment_pref_screen, root)
    }
}