package me.vldf.lab33

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        inc++
        Log.i("oncreate", "onCreate: $inc")
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener {
            processMenu(this, it)
        }

        findViewById<Button>(R.id.bnToSecond)?.setOnClickListener {
            val intent = Intent(this, Second::class.java)
            startActivity(intent)
        }
    }

    companion object {
        var inc = 0
    }
}