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
import com.android.volley.AuthFailureError
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley


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

                // Add the Volley request here
                val url = "http://192.168.1.2/Simple/myfile.php"
                val myRequestQueue: RequestQueue = Volley.newRequestQueue(this)

                val stringRequest = object : StringRequest(
                    Request.Method.POST, url,
                    Response.Listener<String> { response ->
                        Toast.makeText(applicationContext, response, Toast.LENGTH_LONG).show()
                    },
                    object : Response.ErrorListener {
                        override fun onErrorResponse(error: VolleyError) {
                            Toast.makeText(
                                applicationContext,
                                error.message.toString(),
                                Toast.LENGTH_LONG
                            ).show()
                        }
                    }) {

                    @Throws(AuthFailureError::class)
                    override fun getParams(): Map<String, String> {
                        val map = HashMap<String, String>()
                        map["username"] = username
                        map["password"] = password
                        return map
                    }
                }

                myRequestQueue.add(stringRequest)

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



