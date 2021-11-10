package me.vldf.lab33

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Third : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_third)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener {
            processMenu(this, it)
        }

        findViewById<Button>(R.id.bnToFirst)?.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java).apply {
                flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
            }
            startActivity(intent)

        }
        findViewById<Button>(R.id.bnToSecond)?.setOnClickListener {
            finish()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        finish()
        return true
    }
}