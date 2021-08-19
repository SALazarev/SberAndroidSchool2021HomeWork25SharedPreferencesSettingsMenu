package com.salazarev.hw25sharedpreferencessettingsmenu

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.salazarev.hw25sharedpreferencessettingsmenu.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportFragmentManager
            .beginTransaction()
            .replace(R.id.container_layout_place, MainFragment())
            .addToBackStack(null)
            .commit()
    }
}