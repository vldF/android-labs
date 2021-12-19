package me.vldf.lab35

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import me.vldf.lab35.databinding.MainActivityBinding

class MainActivity : AppCompatActivity() {
    private lateinit var controller: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = MainActivityBinding.inflate(layoutInflater)
        setContentView(binding.root)

        controller = (
                supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
                ).navController

        setupActionBarWithNavController(
            controller,
            AppBarConfiguration.Builder(controller.graph).build()
        )
        binding.bottomNav.setOnItemSelectedListener {
            if (it.itemId == R.id.nav_view) {
                controller.navigate(R.id.action_open_about)
                true
            } else {
                false
            }
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return controller.navigateUp() || super.onSupportNavigateUp()
    }
}