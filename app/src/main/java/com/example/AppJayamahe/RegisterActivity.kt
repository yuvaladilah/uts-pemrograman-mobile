package com.example.AppJayamahe

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.Toast

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtEmailSign: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtConfirmPassword: EditText
    private lateinit var register: Button
    private lateinit var backhome: Button
    private lateinit var login: Button


    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_register)

        edtEmailSign = findViewById(R.id.inputEmailSign)
        edtUsername = findViewById(R.id.inputUsername)
        edtPassword = findViewById(R.id.inputPasswordSign)
        edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        edtConfirmPassword = findViewById(R.id.inputConfirmPassword)
        edtConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        register = findViewById(R.id.btn_register)
        backhome = findViewById(R.id.back_home)
        login = findViewById(R.id.tv_havent_account)

        btnBackListener()
        btnSignInListener()
        btnRegisterListener()
    }

    private fun btnRegisterListener() {
        register.setOnClickListener {
            val email = edtEmailSign.text.toString()
            if (emailExist(email)) {
                Toast.makeText(this, "Email Already Used", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek apakah password dan confirm password sama
            if (edtPassword.text.toString() != edtConfirmPassword.text.toString()) {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            // Cek apakah semua edittext terisi
            if (edtUsername.text.toString().isEmpty() ||
                edtPassword.text.toString().isEmpty() ||
                edtEmailSign.text.toString().isEmpty() ||
                edtConfirmPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Make sure all columns are filled in", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // simpan data register
            val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
            val editor = sharedPreferences.edit()
            editor.putString("username", edtUsername.text.toString())
            editor.putString("password", edtPassword.text.toString())
            editor.putString("email", edtEmailSign.text.toString())
            editor.putString("confirm_password", edtConfirmPassword.text.toString())
            editor.apply()

            // tampilkan "Register Berhasil"
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()

            // Kembali Ke Halaman Login
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun emailExist(email: String): Boolean {
        // cek apakah email sudah ada di shared preferences
        val sharedPreferences = getSharedPreferences("my_preferences", MODE_PRIVATE)
        val storedEmail = sharedPreferences.getString("email", "")
        return email == storedEmail
    }

    private fun btnBackListener() {
        // Assuming you have back_2 view in your layout
        backhome.setOnClickListener {
            startActivity(Intent(this, HomeActivity::class.java))
        }
    }

    private fun btnSignInListener() {
        // Assuming you have txt_signin view in your layout
        login.setOnClickListener {
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }
}

