package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.Model.AddCampModel
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddCamp : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_camp)

        firebaseAuth = FirebaseAuth.getInstance()
        dbRef = FirebaseDatabase.getInstance().getReference("BloodCamp_Data")

        val submit = findViewById<Button>(R.id.button7)
        submit.setOnClickListener {

            val organizationName = findViewById<EditText>(R.id.editTextText8).text.toString()
            val venue = findViewById<EditText>(R.id.editTextText9).text.toString()
            val date = findViewById<EditText>(R.id.editTextDate2).text.toString()
            val description = findViewById<EditText>(R.id.editTextText10).text.toString()

            // Retrieve the current user's UID
            val auth = firebaseAuth.currentUser
            val userId = auth?.uid

            if (auth != null) {

                val dataModel = AddCampModel(
                   userId.toString(),
                    organizationName,
                    venue,
                    date,
                    description
                )

                dbRef.child(dbRef.push().key!!.toString()).setValue(dataModel)
                    .addOnCompleteListener {
                        Toast.makeText(this, "Data added success", Toast.LENGTH_LONG).show()

                        val intent1 = Intent(this,BloodCamp::class.java)
                        startActivity(intent1)

                    }.addOnFailureListener { err ->
                        Toast.makeText(this, "Data Not success", Toast.LENGTH_LONG).show()
                    }
            } else {
                Toast.makeText(this, "User Error", Toast.LENGTH_LONG).show()
            }
        }

    }
}