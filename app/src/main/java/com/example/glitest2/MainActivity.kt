package com.example.glitest2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.textfield.TextInputLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val usernameEditText = findViewById<EditText>(R.id.editTextTextUsername)
        val passwordEditText = findViewById<EditText>(R.id.editTextTextPassword)
        val loginButton = findViewById<Button>(R.id.button2)
        val textInputLayoutPassword = findViewById<TextInputLayout>(R.id.textInputLayoutPassword)

        textInputLayoutPassword.setEndIconOnClickListener{
            val passwordVisible = passwordEditText.inputType != InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            passwordEditText.inputType = if (passwordVisible) {
                InputType.TYPE_TEXT_VARIATION_VISIBLE_PASSWORD
            } else {
                InputType.TYPE_CLASS_TEXT or InputType.TYPE_TEXT_VARIATION_PASSWORD
            }
            passwordEditText.setSelection(passwordEditText.length())
        }

        loginButton.setOnClickListener{
            val username = usernameEditText.text.toString()
            val password = passwordEditText.text.toString()

            if (username.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Username and password must be filled", Toast.LENGTH_SHORT)
                    .show()
            } else if (username == "alfagift-admin" && password == "asdf"){
                val intent = Intent(this, student_list::class.java)
                startActivity(intent)
            } else {
                Toast.makeText(this, "Login unauthorized", Toast.LENGTH_SHORT).show()
            }
        }
    }
}