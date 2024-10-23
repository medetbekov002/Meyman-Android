package com.example.meyman.presentation.ui.activity

import android.os.Bundle
import android.view.View
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.app.AppCompatDelegate
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.core.view.isGone
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import com.example.meyman.R
import com.example.meyman.data.remote.dtos.auth.token.RefreshTokenDto
import com.example.meyman.data.remote.preferences.UserDataPreferencesHelper
import com.example.meyman.databinding.ActivityMainBinding
import com.example.meyman.presentation.base.Resource
import dagger.hilt.android.AndroidEntryPoint
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel by viewModels<MainViewModel>()

    @Inject
    lateinit var userPreferencesData: UserDataPreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        installSplashScreen()
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setupNavController()
        setInternetConnection()
        if (userPreferencesData.isAuthorized) {
            refreshAccessToken()
        }
    }

    private fun setupNavController() {
        val navHostFragment: NavHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment_activity_main) as NavHostFragment
        val navController = navHostFragment.navController
        val navGraph = navController.navInflater.inflate(R.navigation.mobile_navigation)

        if (!userPreferencesData.saveOnBoard) {
            navGraph.setStartDestination(R.id.onBoardFragment)
            binding.bottomNavigation.isGone = true
        } else {
            navGraph.setStartDestination(R.id.homeFragment)
            binding.bottomNavigation.isGone = false
        }

        navController.graph = navGraph
        navController.addOnDestinationChangedListener { _, destination, _ ->
            if (destination.id == R.id.onBoardFragment) {
                binding.bottomNavigation.visibility = View.GONE
            } else {
                binding.bottomNavigation.visibility = View.VISIBLE
            }
        }

        binding.bottomNavigation.setOnNavigationItemSelectedListener { item ->
            when (item.itemId) {
                R.id.navigation_home -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }

                R.id.navigation_favorite -> {
                    navController.navigate(R.id.wishlistFragment)
                    true
                }

                R.id.navigation_booking -> {
                    navController.navigate(R.id.reservationFragment)
                    true
                }

                R.id.navigation_prof -> {
                    if (userPreferencesData.isAuthorized) {
                        navController.navigate(R.id.userProfileFragment)
                    } else {
                        navController.navigate(R.id.guestProfileFragment)
                    }
                    true
                }

                else -> false
            }
        }
    }

    private fun refreshAccessToken() {
        val executor = Executors.newScheduledThreadPool(1)
        executor.scheduleAtFixedRate({
            if (userPreferencesData.isAuthorized) {
                lifecycleScope.launchWhenStarted {
                    val token = RefreshTokenDto(userPreferencesData.refreshToken)
                    viewModel.getToken(token).collect { it ->
                        when (it) {
                            is Resource.Error -> {}

                            is Resource.Loading -> {}

                            is Resource.Success -> {
                                userPreferencesData.accessToken = it.data!!.access
                            }
                        }
                    }
                }
            }
        }, 0, 20, TimeUnit.MINUTES)
    }

    private fun setInternetConnection() {
        /*       ConnectionLiveData(application).observe(this) {
                   binding.clNoInternet.isVisible = !it
                   binding.bottomNavigation.isVisible = it
               }

               val retry = findViewById<Button>(R.id.btn_retry)
               val progressBar = findViewById<ProgressBar>(R.id.pb_no_internet)
               retry.setOnClickListener {
                   progressBar.isVisible = true
                   retry.isVisible = false
                   Handler().postDelayed({
                       progressBar.isVisible = true
                       retry.isVisible = true
                   }, 4000L)
               }*/
    }
}