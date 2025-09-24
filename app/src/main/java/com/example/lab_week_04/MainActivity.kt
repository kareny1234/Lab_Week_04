package com.example.lab_week_04

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set toolbar as ActionBar
        setSupportActionBar(findViewById(R.id.toolbar))

        // Get NavHostFragment
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.navController

        // Top-level destinations
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.listFragment,   // Your coffee list
                R.id.favoritesFragment // Your favorites screen
            ),
            findViewById(R.id.drawer_layout) // DrawerLayout reference
        )

        // Hook up ActionBar with Navigation
        setupActionBarWithNavController(navController, appBarConfiguration)

        // Hook up NavigationView with NavController
        findViewById<NavigationView>(R.id.nav_view)
            ?.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }
}
