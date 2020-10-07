package com.example.madlevel4example2.ui

import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.findNavController
import com.example.madlevel4example2.R

class MainActivity : AppCompatActivity() {
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbarHistory))

        navController = findNavController(R.id.nav_host_fragment)

        toggleNavIcon()
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.btn_nav_icon_delete -> {
                true
            }
            R.id.btn_nav_icon_history -> {

                navController.navigate(R.id.action_HomeFragment_to_historyFragment)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        onBackPressed()
        return true
    }

    override fun onBackPressed() {
        val count = supportFragmentManager.backStackEntryCount
        Log.v(Log.DEBUG.toString(), String.format("Het leven: %d", count))
        if (count == 0) {
            super.onBackPressed()
        } else {
            supportActionBar?.setHomeButtonEnabled(false)
            supportFragmentManager.popBackStack()
        }
    }

    /**
     * This method listens to the destination change and should switch the available
     * icons shown in the toolbar and change the title
     *
     */
    private fun toggleNavIcon() {
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id in arrayOf(R.id.historyFragment)) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
                supportActionBar?.setTitle(R.string.title_fragment_history)
            } else {
                supportActionBar?.setDisplayHomeAsUpEnabled(false)
            }
        }

        Log.v(
            Log.DEBUG.toString(),
            String.format("Het water: %d", supportFragmentManager.backStackEntryCount)
        )

    }

}