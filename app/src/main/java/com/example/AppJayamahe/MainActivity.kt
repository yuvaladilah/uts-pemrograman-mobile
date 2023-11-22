package com.example.AppJayamahe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        loadFragment(DashboardFragment())
        var bottomNav = findViewById<BottomNavigationView>(R.id.navBar)

        bottomNav.setOnItemSelectedListener {
            when (it.itemId) {
                R.id.bott_menu_home -> {
                    loadFragment(DashboardFragment())
                    true
                }
                R.id.bott_menu_calc -> {
                    loadFragment(CalculatorFragment())
                    true
                }
                R.id.bott_menu_currency -> {
                    loadFragment(ConvertCurrentFragment())
                    true
                }
                R.id.bott_menu_bmi -> {
                    loadFragment(BmiFragment())
                    true
                } else -> {
                    false
                }
            }
        }

    }

    private  fun loadFragment(fragment: Fragment){
        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.container,fragment)
        transaction.commit()
    }



}