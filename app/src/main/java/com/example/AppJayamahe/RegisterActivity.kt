package com.example.AppJayamahe

import android.content.Intent
import android.os.Bundle
import android.text.method.PasswordTransformationMethod
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*

class RegisterActivity : AppCompatActivity() {

    private lateinit var edtEmailSign: EditText
    private lateinit var edtUsername: EditText
    private lateinit var edtPassword: EditText
    private lateinit var edtConfirmPassword: EditText
    private lateinit var register: Button
    private lateinit var databaseReference: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        // Initialize Firebase Realtime Database
        databaseReference =
            FirebaseDatabase.getInstance().getReferenceFromUrl("https://appjayamahe-default-rtdb.firebaseio.com/")

        edtEmailSign = findViewById(R.id.inputEmailSign)
        edtUsername = findViewById(R.id.inputUsername)
        edtPassword = findViewById(R.id.inputPasswordSign)
        edtPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        edtConfirmPassword = findViewById(R.id.inputConfirmPassword)
        edtConfirmPassword.transformationMethod = PasswordTransformationMethod.getInstance()
        register = findViewById(R.id.btn_register)

        btnRegisterListener()
    }

    private fun btnRegisterListener() {
        register.setOnClickListener {
            val email = edtEmailSign.text.toString()
            if (emailExist(email)) {
                Toast.makeText(this, "Email Already Used", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (edtPassword.text.toString() != edtConfirmPassword.text.toString()) {
                Toast.makeText(this, "Incorrect Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (edtUsername.text.toString().isEmpty() ||
                edtPassword.text.toString().isEmpty() ||
                edtEmailSign.text.toString().isEmpty() ||
                edtConfirmPassword.text.toString().isEmpty()
            ) {
                Toast.makeText(this, "Make sure all columns are filled in", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            // Save registration data to Firebase Realtime Database
            val userId = databaseReference.child("users").push().key // Create a unique key for each user
            val userRef = databaseReference.child("users").child(userId!!)
            userRef.child("username").setValue(edtUsername.text.toString())
            userRef.child("email").setValue(email)

            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()

            // Return to the Login Page
            startActivity(Intent(this, LoginActivity::class.java))
        }
    }

    private fun emailExist(email: String): Boolean {
        // Check if the email already exists in the Firebase Realtime Database
        // Modify this logic according to your data structure and application needs
        return false
    }
}
