package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class AboutUs : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about_us)

        var button30 = findViewById<Button>(R.id.button30)
        button30.setOnClickListener{
            val intent1 = Intent(this,Dashboard::class.java)
            startActivity(intent1)
        }
    }
}