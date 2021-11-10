package me.vldf.lab32

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class First : AppCompatActivity() {
    private val secondLauncher = registerForActivityResult(Contract(Second::class.java)) { }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener {
            processMenu(this, it)
        }

        findViewById<Button>(R.id.to_second)?.setOnClickListener {
            secondLauncher.launch(2)
        }
    }
}