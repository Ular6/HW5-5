package com.example.lovecalculator.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.navigation.findNavController
import com.example.lovecalculator.R
import com.example.lovecalculator.databinding.ActivityMainBinding
import com.example.lovecalculator.ui.utils.Preferences
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private var binding: ActivityMainBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding!!.root)

        val navController = findNavController(R.id.nav_host_fragment)

        val preferences = Preferences(this)
        if (preferences.getHaveSeenOnBoarding()) {
            navController.navigate(
                R.id.mainFragment
            )
        } else {
            navController.navigate(
                R.id.onBoardFragment
            )
        }
    }
}