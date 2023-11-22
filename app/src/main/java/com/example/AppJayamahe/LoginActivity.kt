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
import androidx.fragment.app.Fragment


class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        edtEmail = findViewById(R.id.inputEmail)
        edtPassword = findViewById(R.id.inputPassword)
        edtPassword.setTransformationMethod(PasswordTransformationMethod())
        btnLogin = findViewById(R.id.btn_login)
        tvSignUp = findViewById(R.id.tv_havent_account)


        btnSubmitListener()
        btnSignUpListener()

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
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)

//                var mainFragment: DashboardFragment = DashboardFragment()
//                supportFragmentManager.beginTransaction().add(R.id.container, mainFragment)
//                    .commit()


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

