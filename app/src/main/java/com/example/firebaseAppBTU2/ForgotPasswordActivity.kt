package com.example.firebaseAppBTU2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth

class ForgotPasswordActivity : AppCompatActivity() {
    private lateinit var ForgotPassword: EditText
    private lateinit var ResetPassword: Button
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot_password)

        ForgotPassword = findViewById(R.id.ForgotPasswordEmail)
        ResetPassword = findViewById(R.id.ForgotPassword)
        auth = FirebaseAuth.getInstance()

        ResetPassword.setOnClickListener {
            val email = ForgotPassword.text.toString()

            if(email.isEmpty()){
                Toast.makeText(this,"Please enter a valid Email",Toast.LENGTH_SHORT).show()
            }else{
                auth.sendPasswordResetEmail(email)
                    .addOnSuccessListener {
                        Toast.makeText(this, "Please check your email", Toast.LENGTH_SHORT).show()
                    }

                    .addOnFailureListener {
                        Toast.makeText(this, it.toString(), Toast.LENGTH_SHORT).show()
                    }

            }

        }
    }
}


