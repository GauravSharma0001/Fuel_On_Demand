package com.example.fuelondemand

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.example.fuelondemand.databinding.ActivitySignupBinding
import com.example.fuelondemand.model.UserModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class SignupActivity : AppCompatActivity() {
    private lateinit var auth: FirebaseAuth
    private lateinit var email: String
    private lateinit var password: String
    private lateinit var database: DatabaseReference
    private lateinit var username: String

    private val binding: ActivitySignupBinding by lazy {
        ActivitySignupBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        auth = Firebase.auth
        database = Firebase.database.reference
        binding.createUserButton.setOnClickListener() {
            username = binding.userName.text.toString().trim()
            email = binding.userEmail.text.toString().trim()
            password = binding.userPassword.text.toString().trim()

            if (username.isBlank() || email.isBlank() || password.isBlank()) {
                Toast.makeText(this, "Please fill all the details", Toast.LENGTH_SHORT).show()
            } else {
                createAccount(email, password)
            }
        }

        binding.donthaveButton.setOnClickListener() {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }

    }

    private fun createAccount(email: String, password: String) {
        auth.createUserWithEmailAndPassword(email,password).addOnCompleteListener{
            task->
            if (task.isSuccessful){
                Toast.makeText(this,"Account Created Successfully",Toast.LENGTH_SHORT).show()
                saveUserData()
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
                finish()
            }
            else{
                Toast.makeText(this,"Account Creation Failed",Toast.LENGTH_SHORT).show()
                Log.d("Account","Create Account Failure",task.exception)
            }
        }
    }
//Save User Data into Database
    private fun saveUserData() {
        username = binding.userName.text.toString().trim()
        email = binding.userEmail.text.toString().trim()
        password = binding.userPassword.text.toString().trim()
        val user=UserModel(username,email,password)
        val userId = FirebaseAuth.getInstance().currentUser!!.uid
//    Save User Data in Firebase Database
        database.child("user").child(userId).setValue(user)
    }
}