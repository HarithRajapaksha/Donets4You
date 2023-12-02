package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import com.example.Model.LastWishModel
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class LastWish : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_last_wish)

        firebaseAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("LastWish_Data")

        var submit = findViewById<Button>(R.id.button80)
        submit.setOnClickListener {

            val firstNameText = findViewById<EditText>(R.id.editTextText8).text.toString()
            val lastNameText = findViewById<EditText>(R.id.editTextText28).text.toString()
            val phoneNumberText = findViewById<EditText>(R.id.editTextPhone2).text.toString()
            val emailText = findViewById<EditText>(R.id.editTextTextEmailAddress26).text.toString()
            val addressText = findViewById<EditText>(R.id.editTextTextPostalAddress5).text.toString()
            val checkBox = findViewById<CheckBox>(R.id.checkBox2)
            val isCertified = checkBox.isChecked
            val notifierNameText = findViewById<EditText>(R.id.editTextText5).text.toString()
            val notifierPhoneNumberText = findViewById<EditText>(R.id.editTextPhone13).text.toString()
            val lastWishText = findViewById<EditText>(R.id.editTextText25).text.toString()

            // Retrieve the current user's UID
            val auth1 = firebaseAuth.currentUser
            val userId = auth1?.uid

            if (auth1 != null) {
                // You can use the retrieved data here or perform further actions
                // For example, you might want to create a LastWishModel object
                // and store it in the Firebase Realtime Database
                val dataModel = LastWishModel(
                    userId,
                    firstNameText,
                    lastNameText,
                    phoneNumberText,
                    emailText,
                    addressText,
                    isCertified,
                    notifierNameText,
                    notifierPhoneNumberText,
                    lastWishText,
                )

                dbRef.child(userId.toString()).setValue(dataModel)
                    .addOnCompleteListener {
                        Toast.makeText(this, "Data added", Toast.LENGTH_LONG).show()

                        val intent1 = Intent(this, Donors::class.java)
                        startActivity(intent1)

                    }.addOnFailureListener { err ->
                        Toast.makeText(this, "Data Not added", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "User is Not identified", Toast.LENGTH_LONG).show()
            }
        }


    }
}
