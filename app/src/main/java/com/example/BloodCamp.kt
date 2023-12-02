package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.DonationCampsFetchdata
import com.example.myapplication.R

class BloodCamp : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_blood_camp)

        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener{
            val intent1 = Intent(this,AddCamp::class.java)
            startActivity(intent1)
        }

        var button5 = findViewById<Button>(R.id.button5)
        button5.setOnClickListener{
            val intent = Intent(this,DonationCampsFetchdata::class.java)
            startActivity(intent)
        }

        var button13 = findViewById<Button>(R.id.button13)
        button13.setOnClickListener{
            val intent2 = Intent(this,Dashboard::class.java)
            startActivity(intent2)
        }
    }
}