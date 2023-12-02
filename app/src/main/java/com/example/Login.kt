package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.google.android.material.textfield.TextInputLayout
import com.google.firebase.auth.FirebaseAuth

class Login : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()

        var btnsignup = findViewById<Button>(R.id.btnsignup)
        btnsignup.setOnClickListener {
            val intent2 = Intent(this, Registration::class.java)
            startActivity(intent2)
        }

        var btnsignin = findViewById<Button>(R.id.signin)

        var email=findViewById<EditText>(R.id.email)
        var password=findViewById<EditText>(R.id.password)

        btnsignin.setOnClickListener {
            var emailText = email.text.toString()
            var passwordText = password.text.toString()

            firebaseAuth.signInWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {

                        Toast.makeText(this, "Login success", Toast.LENGTH_LONG).show()

                        val intent=Intent(this@Login,DonerReg::class.java)
                        intent.putExtra("uid",firebaseAuth.currentUser?.uid.toString())
                        startActivity(intent)

                        val intent1 = Intent(this, Dashboard::class.java)
                        startActivity(intent1)
                    } else {
                        Toast.makeText(this, "Login Unsuccessful: ${task.exception?.message}", Toast.LENGTH_LONG).show()
                    }
                }
                .addOnFailureListener { err ->
                    Toast.makeText(this, "Login Unsuccessful: $err", Toast.LENGTH_LONG).show()
                }
        }
    }
}
