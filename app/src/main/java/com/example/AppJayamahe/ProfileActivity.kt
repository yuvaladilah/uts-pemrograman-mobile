package com.example.AppJayamahe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView

class ProfileActivity : AppCompatActivity() {

    private lateinit var backhome: ImageView

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        backhome = findViewById(R.id.back_home)

        backhome.setOnClickListener {
            val intent = Intent(this, DashboardFragment::class.java)
            startActivity(intent)
        }
    }
}