package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class Donors : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_donors)

        var backButton = findViewById<Button>(R.id.button12)
        var btnregdonor = findViewById<Button>(R.id.btnregdonor)
        var btnregLastWish = findViewById<Button>(R.id.btnregafterdeath)

        backButton.setOnClickListener{
            val intent1 = Intent(this,Dashboard::class.java)
            startActivity(intent1)
        }


       btnregdonor.setOnClickListener{
            val intent2 = Intent(this,DonerReg::class.java)
            startActivity(intent2)
        }


        btnregLastWish.setOnClickListener{
            val intent3= Intent(this,LastWish::class.java)
            startActivity(intent3)
        }


    }
}