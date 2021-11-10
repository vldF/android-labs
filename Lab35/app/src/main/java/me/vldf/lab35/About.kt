package me.vldf.lab35

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.ui.setupActionBarWithNavController

class About : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}