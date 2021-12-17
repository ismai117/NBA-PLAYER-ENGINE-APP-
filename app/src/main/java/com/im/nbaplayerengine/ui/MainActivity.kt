package com.im.nbaplayerengine.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.widget.Toolbar
import androidx.core.view.GravityCompat
import androidx.drawerlayout.widget.DrawerLayout
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.*
import com.google.android.material.navigation.NavigationView
import com.im.nbaplayerengine.R
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {

    private lateinit var toggle: ActionBarDrawerToggle
    private lateinit var drawer: DrawerLayout
    private lateinit var nav: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawer = findViewById(R.id.mainDrawer)
        toggle = ActionBarDrawerToggle(this, drawer, R.string.open, R.string.close)
        drawer.addDrawerListener(toggle)
        toggle.syncState()

        nav = findViewById(R.id.mainNav)


        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        nav.setNavigationItemSelectedListener(this)

        supportActionBar?.title = "NBAPLAYERENGINE"

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        if (toggle.onOptionsItemSelected(item)) {
            return true
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {

        when (item.itemId) {

            R.id.home_menu -> {
                findNavController(R.id.navhost).navigate(R.id.dashboardFragment)
                supportActionBar?.title = "NBAPLAYERENGINE"
                return true
            }

            R.id.news_menu -> {
                findNavController(R.id.navhost).navigate(R.id.newsFragment)
                supportActionBar?.title = "News"
                return true
            }

            R.id.players_menu -> {
                findNavController(R.id.navhost).navigate(R.id.playersFragment)
                supportActionBar?.title = "Players"
                return true
            }

            R.id.teams_menu -> {
                findNavController(R.id.navhost).navigate(R.id.teamsFragment)
                supportActionBar?.title = "Teams"
                return true
            }

        }

        return false
    }


}