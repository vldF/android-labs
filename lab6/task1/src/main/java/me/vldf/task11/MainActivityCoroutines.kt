package me.vldf.task11

import android.annotation.SuppressLint
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import kotlinx.coroutines.*
import kotlin.math.roundToLong

class MainActivityCoroutines : AppCompatActivity() {
    private var baseTime: Long = 0
    private var startTime: Long = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences

    companion object {
        const val SECONDS_KEY = "seconds"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getPreferences(Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)

        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                while (true) {
                    delay(10)
                    MainScope().launch {
                        textSecondsElapsed.text = "Seconds elapsed: " + getCurrentTimeToShow()
                    }
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    override fun onStart() {
        super.onStart()
        baseTime = sharedPref.getLong(SECONDS_KEY, 0)
        startTime = System.currentTimeMillis()
    }

    override fun onStop() {
        super.onStop()

        with(sharedPref.edit()) {
            putLong(SECONDS_KEY, getCurrentTimeToShow())
            apply()
        }
    }

    private fun getCurrentTimeToShow(): Long {
        return baseTime + ((currentTime - startTime) / 1000.0).roundToLong()
    }

    private val currentTime: Long
        get() = System.currentTimeMillis()
}