package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.Model.Addnewsfeed
import com.example.myapplication.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase

class AddNews : AppCompatActivity() {

    private lateinit var dbRef: DatabaseReference
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add_news)

        var submitLastwish = findViewById<Button>(R.id.submitLastwish)

        submitLastwish.setOnClickListener{

            var name=findViewById<EditText>(R.id.editTextText20).text.toString()
            var phone=findViewById<EditText>(R.id.editTextPhone2).text.toString()
            var bood=findViewById<EditText>(R.id.editTextText4).text.toString()
            var orgen=findViewById<EditText>(R.id.editTextText5).text.toString()

            firebaseAuth = FirebaseAuth.getInstance()
            dbRef = FirebaseDatabase.getInstance().getReference("NewsFeed")

            val auth = firebaseAuth.currentUser
            val userId = auth?.uid

            if (auth != null){
                val data=Addnewsfeed(userId.toString(),name,phone,bood,orgen)

                dbRef.child(dbRef.push().key!!.toString()).setValue(data).addOnCompleteListener {
                    Toast.makeText(this,"News data added",Toast.LENGTH_LONG).show()

                    val intent1 = Intent(this,Donors::class.java)
                    startActivity(intent1)

                }.addOnFailureListener {
                    Toast.makeText(this,"News data not added",Toast.LENGTH_LONG).show()
                }
            }else{
                Toast.makeText(this,"User not identified",Toast.LENGTH_LONG).show()
            }

        }
    }
}