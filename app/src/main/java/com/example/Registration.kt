package com.example

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.R
import com.example.Model.RegisterModel
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class Registration : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth
    private lateinit var dbRef: DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        // Initialize FirebaseAuth and DatabaseReference
        firebaseAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("UsersData")

        val firstName = findViewById<EditText>(R.id.first)
        val lastName = findViewById<TextView>(R.id.last)
        val email = findViewById<TextView>(R.id.email) //get
        val phone = findViewById<TextView>(R.id.Phone)
        val password = findViewById<TextView>(R.id.nepassword) //get
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {

            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            val firstNameText =firstName.text.toString()
            val lastNameText = lastName.text.toString()
            val phoneText = phone.text.toString()

            firebaseAuth.createUserWithEmailAndPassword(emailText, passwordText)
                .addOnCompleteListener(this) { task ->
                    if (task.isSuccessful) {
                        Toast.makeText(this, "SIGN UP SUCCESS", Toast.LENGTH_LONG).show()

                        val auth1=firebaseAuth.currentUser
                        val userId=auth1?.uid

                        val dataModel=
                            RegisterModel(userId,firstNameText,lastNameText,emailText,phoneText)

                        dbRef.child(userId!!).setValue(dataModel).addOnSuccessListener {
                            Toast.makeText(this,"AthorData Added", Toast.LENGTH_LONG).show()
                        }.addOnFailureListener {err->
                            Toast.makeText(this,"AthorData not Added ${err}", Toast.LENGTH_LONG).show()
                        }

                    } else {
                        Toast.makeText(
                            this,
                            "Authentication data not added: ${task.exception?.message}",
                            Toast.LENGTH_LONG
                        ).show()
                    }

                }
        }
    }
}


