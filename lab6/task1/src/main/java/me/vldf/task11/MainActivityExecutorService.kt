package me.vldf.task11

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.Job
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors
import java.util.concurrent.Future
import kotlin.math.roundToLong

class MainActivityExecutionService : AppCompatActivity() {
    private var baseTime: Long = 0
    private var startTime: Long = 0
    private lateinit var textSecondsElapsed: TextView
    private lateinit var sharedPref: SharedPreferences
    private lateinit var timeExecutor: Future<*>
    private val executor by lazy { (application as ExecutorServiceBasedApplication).executor }

    companion object {
        const val SECONDS_KEY = "seconds"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        sharedPref = getPreferences(Context.MODE_PRIVATE)
        setContentView(R.layout.activity_main)
        textSecondsElapsed = findViewById(R.id.textSecondsElapsed)
    }

    override fun onStart() {
        super.onStart()
        baseTime = sharedPref.getLong(SECONDS_KEY, 0)
        timeExecutor = executor.submit(getRunnable())
        startTime = System.currentTimeMillis()
    }

    override fun onStop() {
        super.onStop()
        timeExecutor.cancel(true)
        with(sharedPref.edit()) {
            putLong(SECONDS_KEY, getCurrentTimeToShow())
            apply()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun getRunnable() = Runnable {
        while (!Thread.currentThread().isInterrupted) {
            try {
                Thread.sleep(10)
            } catch (e: InterruptedException) {
                Log.d("thread", "thread is interrupted")
            }
            textSecondsElapsed.post {
                textSecondsElapsed.text = "Seconds elapsed: " + getCurrentTimeToShow()
            }
        }
    }

    private fun getCurrentTimeToShow(): Long {
        return baseTime + ((currentTime - startTime) / 1000.0).roundToLong()
    }

    private val currentTime: Long
        get() = System.currentTimeMillis()
}

class ExecutorServiceBasedApplication : Application() {
    var executor: ExecutorService = Executors.newSingleThreadExecutor()
}