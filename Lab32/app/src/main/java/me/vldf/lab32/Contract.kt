package me.vldf.lab32

import android.content.Context
import android.content.Intent
import androidx.activity.result.contract.ActivityResultContract

class Contract(private val activity: Class<*>) : ActivityResultContract<Int, Int>() {
    override fun createIntent(context: Context, input: Int): Intent {
        return Intent(context, activity)
            .putExtra(TO_KEY, input)
    }

    override fun parseResult(resultCode: Int, intent: Intent?): Int {
        return intent?.getIntExtra(TO_KEY, -1) ?: -1
    }
}