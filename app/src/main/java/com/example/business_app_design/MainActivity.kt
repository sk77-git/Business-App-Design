package com.example.business_app_design


import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.view.WindowManager
import android.widget.RelativeLayout
import android.widget.Toast

import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView



class MainActivity : AppCompatActivity() {
    private val tag: String= "MainActivity"
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val mainLayout:RelativeLayout= findViewById(R.id.mainLayout)
        /*Setting default colors*/
        setStatusBarSoftKeyAndMainColor(R.color.bg_light_grey, mainLayout = mainLayout)

        /*Setting Bottom Nav*/
        val bottomNavigationView= findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        val navController= findNavController(R.id.fragmentContainerView)
        bottomNavigationView.setupWithNavController(navController)

        /*setting custom toolbar*/
        val toolbar: androidx.appcompat.widget.Toolbar= findViewById(R.id.myToolbar)
        setSupportActionBar(toolbar)
        val appBarConfiguration= AppBarConfiguration(navController.graph)
        toolbar.setupWithNavController(navController,appBarConfiguration)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.homeFragment -> {
                    toolbar.visibility = View.GONE
                    bottomNavigationView.visibility = View.VISIBLE
                    setStatusBarSoftKeyAndMainColor(R.color.bg_light_grey, mainLayout = mainLayout)
                }
                R.id.welcomeFragment -> {
                    toolbar.visibility = View.GONE
                    bottomNavigationView.visibility = View.GONE
                    //hideStatusBar();
                    setStatusBarSoftKeyAndMainColor(R.color.primary_light_green, mainLayout = mainLayout)
                }
                else -> {
                    toolbar.visibility = View.VISIBLE
                    bottomNavigationView.visibility = View.VISIBLE
                    setStatusBarSoftKeyAndMainColor(R.color.white, mainLayout = mainLayout)
                }
            }
            Log.d(tag, "onCreate: "+destination.id)
        }

    }

    private fun hideStatusBar() {
        window.decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_FULLSCREEN
        actionBar?.hide()
    }
    /*main Color is main activity's parent layout's color which is transparent by default*/
    private fun setStatusBarSoftKeyAndMainColor( colorId: Int, mainLayout: RelativeLayout) {
        val window = this.window
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS)
        window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS)
        window.statusBarColor = this.resources.getColor(colorId)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            getWindow().decorView.systemUiVisibility = View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR
        } //  set status text dark
        resources.getColor(colorId).also { getWindow().navigationBarColor = it } //softKey color
        resources.getDrawable(colorId).also { mainLayout.background = it } //bgColor

    }
    override fun onCreateOptionsMenu(menu1: Menu?): Boolean {
        menuInflater.inflate(R.menu.bottom_menu, menu1)
        return true
    }
    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.homeFragment -> {
                Toast
                    .makeText(
                        applicationContext,
                        getString(R.string.home),
                        Toast.LENGTH_SHORT
                    )
                    .show()
                return true
            }
            R.id.statsFragment->{
                Toast.makeText(this, getString(R.string.overview), Toast.LENGTH_SHORT).show()
            }
            R.id.settingsFragment->{
                Toast.makeText(this, getString(R.string.setting), Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}