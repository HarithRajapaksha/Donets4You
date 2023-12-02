package com.example

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.Model.DonoursRegModel
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class DonerReg : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_doner_reg)

        firebaseAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("Donours_Data")

        var submit = findViewById<Button>(R.id.submit8)
        submit.setOnClickListener {

            val firstNameText = findViewById<EditText>(R.id.firstName).text.toString()
            val lastNameText = findViewById<EditText>(R.id.lastName).text.toString()
            val emailText = findViewById<EditText>(R.id.Email).text.toString()
            val phoneText = findViewById<EditText>(R.id.phoneNumber).text.toString()
            val dobText = findViewById<EditText>(R.id.dob).text.toString()
            val genderText = findViewById<EditText>(R.id.gender).text.toString()
            val addressText = findViewById<EditText>(R.id.Address).text.toString()
            val bloodgroupText = findViewById<EditText>(R.id.bloodgroup).text.toString()

            val checkBox = findViewById<CheckBox>(R.id.checkBox1)
            val isCertified = checkBox.isChecked

            if (isCertified) {

                val auth1=firebaseAuth.currentUser
                val userId=auth1?.uid
               // val auth1 = intent.getStringExtra("uid")

                if (auth1 != null) {
                    val dataModel = DonoursRegModel(
                        userId,
                        firstNameText,
                        lastNameText,
                        emailText,
                        phoneText,
                        dobText,
                        genderText,
                        addressText,
                        bloodgroupText
                    )

                    dbRef.child(userId.toString()).setValue(dataModel).addOnCompleteListener {
                      Toast.makeText(this,"Data added",Toast.LENGTH_LONG).show()
                    }.addOnFailureListener { err ->
                        Toast.makeText(this,"Data Not added",Toast.LENGTH_LONG).show()
                    }

                    val intent1 = Intent(this, Donors::class.java)
                    startActivity(intent1)
                } else {
                    Toast.makeText(this,"UID Is null",Toast.LENGTH_LONG).show()
                }
            } else {
                Toast.makeText(this,"Please fill ckeakbox FIELD",Toast.LENGTH_LONG).show()
            }
        }
    }
}
