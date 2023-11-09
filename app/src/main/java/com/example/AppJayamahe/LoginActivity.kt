package com.example.AppJayamahe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.MotionEvent
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast


class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView
    private lateinit var backhome: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.inputEmail)
        edtPassword = findViewById(R.id.inputPassword)
        edtPassword.setTransformationMethod(PasswordTransformationMethod())
        btnLogin = findViewById(R.id.btn_login)
        tvSignUp = findViewById(R.id.tv_havent_account)

        btnBackListener()
        btnSubmitListener()
        btnSignUpListener()

    }

    private fun btnBackListener() {
        backhome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun btnSubmitListener() {
        btnLogin.setOnClickListener {
            val username = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
            val storedUsername = sharedPreferences.getString("username", "")
            val storedPassword = sharedPreferences.getString("password", "")
            if (username == storedUsername && password == storedPassword) {
                // Login berhasil
                Toast.makeText(this, "Login successful", Toast.LENGTH_SHORT).show()

                // Kembali ke halaman utama
                startActivity(Intent(this, DashboardFragment::class.java))
            } else {
                // Login gagal
                Toast.makeText(this, "Incorrect username or password", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun btnSignUpListener() {
        tvSignUp.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }
    }
    }

