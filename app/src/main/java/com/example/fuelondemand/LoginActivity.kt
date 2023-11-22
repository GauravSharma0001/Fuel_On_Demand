package com.example.fuelondemand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fuelondemand.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var database: DatabaseReference

private val binding: ActivityLoginBinding by lazy {
    ActivityLoginBinding.inflate(layoutInflater)
}
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = Firebase.auth
        database = Firebase.database.reference
        binding.loginUserButton.setOnClickListener() {
            email = binding.userEmail.text.toString().trim()
            password = binding.userPassword.text.toString().trim()
            if (email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                accountlogin(email,password)
            }
        }
        binding.donthaveButton.setOnClickListener(){
            val intent= Intent ( this, SignupActivity::class.java)
            startActivity(intent)
        }
    }

    private fun accountlogin(email: String, password: String) {
        auth.signInWithEmailAndPassword(email,password).addOnCompleteListener{
                task->
            if (task.isSuccessful) {
                Toast.makeText(this, "Login Successful", Toast.LENGTH_SHORT).show()
                val user = auth.currentUser
                updateUi(user)
            }
            else{
                Toast.makeText(this,"Authentication Failed",Toast.LENGTH_SHORT).show()
                Log.d("Account","Account Authentication Failure",task.exception)
            }

    }
}

    private fun updateUi(user: FirebaseUser?) {
        startActivity(Intent(this, MainActivity::class.java))
        finish()
    }
}


