package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class Donation : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donation)

        var button15 = findViewById<Button>(R.id.button15)
        button15.setOnClickListener{
            val intent1 = Intent(this,Dashboard::class.java)
            startActivity(intent1)
        }
    }
}