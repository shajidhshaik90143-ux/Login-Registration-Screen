package com.example.login

import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputEditText

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val email = findViewById<TextInputEditText>(R.id.etEmail)
        val password = findViewById<TextInputEditText>(R.id.etPassword)
        val confirmPassword = findViewById<TextInputEditText>(R.id.etConfirmPassword)
        val registerBtn = findViewById<Button>(R.id.btnRegister)

        registerBtn.setOnClickListener {

            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString()
            val confirmPasswordText = confirmPassword.text.toString()

            when {
                emailText.isEmpty() -> {
                    email.error = "Email required"
                }
                !Patterns.EMAIL_ADDRESS.matcher(emailText).matches() -> {
                    email.error = "Invalid email"
                }
                passwordText.length < 6 -> {
                    password.error = "Minimum 6 characters"
                }
                passwordText != confirmPasswordText -> {
                    confirmPassword.error = "Passwords do not match"
                }
                else -> {
                    Toast.makeText(this, "Registration Successful", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
