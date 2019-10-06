package com.devign.smack

import android.content.Intent
import android.os.Bundle
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import android.view.View

class MainActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Sets toolbar as a variable
        val toolbar: Toolbar = findViewById(R.id.toolbar)
        // Creates the toolbar
        setSupportActionBar(toolbar)

        // Sets drawer as a variable
        val drawerLayout: DrawerLayout = findViewById(R.id.drawer_layout)
        // Sets nav as a variable
        val navView: NavigationView = findViewById(R.id.nav_view)
        // Set nav controller as a variable
        val navController = findNavController(R.id.messageListView)
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        appBarConfiguration = AppBarConfiguration(
            setOf(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow,
                R.id.nav_tools, R.id.nav_share, R.id.nav_send
            ), drawerLayout
        )
        setupActionBarWithNavController(navController, appBarConfiguration)
        navView.setupWithNavController(navController)
    }

    override fun onSupportNavigateUp(): Boolean {
        // Makes nav controller a variable
        val navController = findNavController(R.id.messageListView)
        //
        return navController.navigateUp(appBarConfiguration) || super.onSupportNavigateUp()
    }

    // ---  BUTTONS  ---

    // Redirect user to LOGIN Activity
    fun loginBtnNavClicked(view: View) {
        val loginIntent = Intent(this, LoginActivity::class.java)
        startActivity(loginIntent)
    }

    fun addChannelClicked(view: View) {

    }

    fun sendMessageBtnClicked(view: View) {

    }


}
