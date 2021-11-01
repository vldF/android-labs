package me.vldf.lab32

import android.content.Context
import android.content.Intent
import android.view.MenuItem

const val TO_KEY = "to"

fun processMenu(context: Context, item: MenuItem): Boolean {
    when (item.itemId) {
        R.id.bottom_menu -> {
            val intent = Intent(context, About::class.java)
            context.startActivity(intent)
            return true
        }
    }
    return false
}