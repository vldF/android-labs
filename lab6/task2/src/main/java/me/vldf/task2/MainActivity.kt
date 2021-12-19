package me.vldf.task2

import android.app.Application
import android.graphics.Bitmap
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity
import java.util.concurrent.Executors
import android.graphics.BitmapFactory
import android.util.Log
import android.widget.ImageView
import java.net.URL
import java.util.concurrent.ExecutorService


class MainActivity : AppCompatActivity() {
    private val executorService by lazy { (application as ExecutorServiceBasedApplication).executor }
    private lateinit var imageView: ImageView
    private val images = mutableListOf(
        URL("https://sun9-82.userapi.com/impg/ig4zJCphZpBvgXkal3Vru0h0V7HjloD1VxgsTA/sYw_HiNtBS4.jpg?size=1200x630&quality=96&sign=3b9b8b7638b925da5ad4108aad642324&type=album"),
        URL("https://sun9-77.userapi.com/impg/ue9VDyK2MhqotClMnVDJ9njEkp6LvluQTJkGGw/z0BlsCGIbi0.jpg?size=600x773&quality=96&sign=b83fc3ffc4c6de87308217c52a7c757d&type=album"),
        URL("https://sun9-33.userapi.com/impg/hQopWF-7ylpgCR9l7y1GgO6rlsIa_eVRAPW9wg/Y8o8qjjPLGs.jpg?size=500x332&quality=96&sign=1f4539fa54bc7fddc095892523da63c5&type=album")
    )
    private val imageCache = mutableMapOf<URL, Bitmap>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main)
        imageView = findViewById(R.id.image)

        findViewById<Button>(R.id.btn).setOnClickListener(::getUpdateImage)
    }

    private fun getUpdateImage(view: View) {
        Log.i("main", "getUpdateImage: pressed")
        view.isClickable = false
        executorService.submit {
            val url = images.random()
            val image = imageCache[url] ?: BitmapFactory.decodeStream(url.openStream())
            imageCache[url] = image
            imageView.post {
                imageView.setImageBitmap(image)
            }
            view.isClickable = true
        }
    }
}

class ExecutorServiceBasedApplication : Application() {
    var executor: ExecutorService = Executors.newSingleThreadExecutor()
}