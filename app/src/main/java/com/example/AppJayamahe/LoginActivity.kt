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
import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.ValueEventListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.*


class LoginActivity : AppCompatActivity() {

    private lateinit var edtEmail: EditText
    private lateinit var edtPassword: EditText
    private lateinit var btnLogin: Button
    private lateinit var tvSignUp: TextView
    // Inisialisasi DatabaseReference untuk node "users"
    private lateinit var usersRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        // Inisialisasi DatabaseReference dengan Firebase Realtime Database
        usersRef = FirebaseDatabase.getInstance().getReference("users")

        edtEmail = findViewById(R.id.inputEmail)
        edtPassword = findViewById(R.id.inputPassword)
        edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        btnLogin = findViewById(R.id.btn_login)
        tvSignUp = findViewById(R.id.tv_havent_account)

        btnSubmitListener()
        btnSignUpListener()

    }



    private fun btnSubmitListener() {
        btnLogin.setOnClickListener {
            val username = edtEmail.text.toString()
            val password = edtPassword.text.toString()

            // Assuming usersRef is a DatabaseReference pointing to your "users" node
            usersRef.orderByChild("username").equalTo(username)
                .addListenerForSingleValueEvent(object : ValueEventListener {
                    override fun onDataChange(dataSnapshot: DataSnapshot) {
                        if (dataSnapshot.exists()) {
                            for (userSnapshot in dataSnapshot.children) {
                                val storedPassword =
                                    userSnapshot.child("password").getValue(String::class.java)

                                if (password == storedPassword) {
                                    // Login successful
                                    Toast.makeText(
                                        this@LoginActivity,
                                        "Login successful",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                    startActivity(
                                        Intent(
                                            this@LoginActivity,
                                            MainActivity::class.java
                                        )
                                    )
                                    finish() // Finish current activity to prevent going back to login form
                                    return
                                }
                            }
                            // Incorrect password
                            Toast.makeText(
                                this@LoginActivity,
                                "Incorrect password",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            // User not found
                            Toast.makeText(this@LoginActivity, "User not found", Toast.LENGTH_SHORT)
                                .show()
                        }
                    }

                    override fun onCancelled(databaseError: DatabaseError) {
                        // Handle error
                        Toast.makeText(this@LoginActivity, "Error during login", Toast.LENGTH_SHORT)
                            .show()
                    }
                })
        }
    }




            private fun btnSignUpListener() {
                tvSignUp.setOnClickListener {
                    startActivity(Intent(this, RegisterActivity::class.java))
                }
            }
        }