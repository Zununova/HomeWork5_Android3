package com.example.homework2_android3.ui.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI.setupWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.homework2_android3.R
import com.example.homework2_android3.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var bottomNavigationListener: OnBottomNavigationSelected
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setUpNav()
    }

    private fun setUpNav() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        navController = navHostFragment.navController

        setupWithNavController(binding.bottomNavigation, navController)

        with(binding.bottomNavigation) {
            setupWithNavController(navController)
            setOnItemReselectedListener {
                when (it.itemId) {
                    R.id.characterFragment,
                    R.id.locationFragment,
                    R.id.episodeFragment
                    -> {
                        bottomNavigationListener.onItemSelect()
                    }
                }
            }
        }
    }

    fun interface OnBottomNavigationSelected {
        fun onItemSelect()
    }

    fun setOnItemReselectedListener(bottomNavigationListener: OnBottomNavigationSelected) {
        this.bottomNavigationListener = bottomNavigationListener
    }
}