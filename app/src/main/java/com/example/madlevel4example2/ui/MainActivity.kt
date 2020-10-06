package com.example.madlevel4example2.ui

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import com.example.madlevel4example2.R

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbarHistory))
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val navController = findNavController(R.id.nav_host_fragment)

        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.btn_nav_icon_delete -> {
                toggleNavIcon()
                true
            }
            R.id.btn_nav_icon_history -> {
                navController.navigate(R.id.action_HomeFragment_to_historyFragment)
                toggleNavIcon()
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

    /**
     * This method should switch the available icons shown in the toolbar and change the title
     */
    private fun toggleNavIcon() {

    }

}