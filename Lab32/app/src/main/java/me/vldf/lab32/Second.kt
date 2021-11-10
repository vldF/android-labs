package me.vldf.lab32

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.google.android.material.bottomnavigation.BottomNavigationView

class Second : AppCompatActivity() {
    private val thirdLauncher = registerForActivityResult(Contract(Third::class.java)) {
        if (it == 2) {
            // do nothing
        } else if (it == 1) {
            backToFirst()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val extra: Bundle = intent.extras ?: error("extras is null")
        val activityNo = extra[TO_KEY] ?: error("to key didn't specified")
        if (activityNo == 3) {
            jumpToThird()
        } else if (activityNo == 1) {
            backToFirst()
        }

        findViewById<BottomNavigationView>(R.id.bottom_nav).setOnItemSelectedListener {
            processMenu(this, it)
        }

        findViewById<Button>(R.id.bnToThird)?.setOnClickListener {
            jumpToThird()
        }
        findViewById<Button>(R.id.bnToFirst)?.setOnClickListener {
            backToFirst()
        }
    }

    private fun jumpToThird() {

        thirdLauncher.launch(3)
    }

    private fun backToFirst() {
        val data = Intent().apply {
            putExtra(TO_KEY, 1)
        }
        setResult(Activity.RESULT_OK, data)
        finish()
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }
}