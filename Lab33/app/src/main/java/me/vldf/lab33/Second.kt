package me.vldf.lab33

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class Second : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener {
            processMenu(this, it)
        }

        findViewById<Button>(R.id.to_third)?.setOnClickListener {
            val intent = Intent(this, Third::class.java)
            startActivity(intent)
        }
        findViewById<Button>(R.id.to_first)?.setOnClickListener {
            finish()
        }
    }

}