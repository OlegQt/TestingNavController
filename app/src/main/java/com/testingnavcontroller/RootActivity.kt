package com.testingnavcontroller

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import com.testingnavcontroller.databinding.ActivityRootBinding
import com.testingnavcontroller.fragments.Content

class RootActivity : AppCompatActivity(), BackNavigateListener {
    lateinit var binding: ActivityRootBinding
    private lateinit var navController: NavController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRootBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navView = binding.rootNavBar

        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragmentContainerView) as NavHostFragment
        navController = navHostFragment.navController
        navView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { controller, destination, arguments ->
            when (destination.id) {
                R.id.filters -> navView.visibility = View.GONE
                else -> navView.visibility = View.VISIBLE
            }
        }
    }

    override fun setOnBackNavigateListener(fragmentName: String) {
        // Здесь надо как то передать дату внутрь фрагмента
        // Но получить текущий фрагмент не удается
        val tempFragment = supportFragmentManager.findFragmentById(R.id.content)
        tempFragment?.let {
            (it as Content).receiveData("Resume to content")
        }
    }
}