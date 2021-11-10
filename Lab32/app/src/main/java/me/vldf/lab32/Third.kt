package me.vldf.lab32

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
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
            back(1)
        }
        findViewById<Button>(R.id.bnToSecond)?.setOnClickListener {
            back(2)
        }
    }

    private fun back(idx: Int) {
        check(idx == 1 || idx == 2)

        val data = Intent().apply {
            putExtra(TO_KEY, idx)
        }
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}