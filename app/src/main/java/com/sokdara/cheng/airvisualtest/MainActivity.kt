package com.sokdara.cheng.airvisualtest

import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.*
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.sokdara.cheng.airvisualtest.ui.MapFragment
import com.sokdara.cheng.airvisualtest.ui.MyAirFragment
import com.sokdara.cheng.airvisualtest.ui.PlaceFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener,
    MyAirFragment.OnFragmentInteractionListener, MapFragment.OnFragmentInteractionListener,
    PlaceFragment.OnFragmentInteractionListener {

    companion object {
        private const val TAG = "MainActivity"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            val w: Window = window
            w.setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            )
        }
        setContentView(R.layout.activity_main)
        // Connect action bar to toolbar
        setSupportActionBar(mainToolbar)
        // Remove appbar title and use AirVisual logo instead
        supportActionBar?.setDisplayShowTitleEnabled(false)
        // Set bottom navigation item selected listener
        bottomNavigation.setOnNavigationItemSelectedListener(this)
        supportFragmentManager.commit {
            replace(R.id.mainContent, MyAirFragment())
            addToBackStack(null)
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.app_bar_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        Log.v(TAG, "$item")
        when (item.itemId) {
            R.id.action_my_air -> {
                mainToolbar.visibility = View.VISIBLE
                supportFragmentManager.commit {
                    replace(R.id.mainContent, MyAirFragment())
                    addToBackStack(null)
                }
                return true
            }
            R.id.action_map -> {
                mainToolbar.visibility = View.GONE
                supportFragmentManager.commit {
                    replace(R.id.mainContent, MapFragment())
                    addToBackStack(null)
                }
                return true
            }
        }
        return false
    }
}
