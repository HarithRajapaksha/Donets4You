package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class Dashboard : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_dashboard)

        var donor = findViewById<Button>(R.id.donor)
        donor.setOnClickListener{
            val intent1 = Intent(this,Donors::class.java)
            startActivity(intent1)
        }

        var newsfeed = findViewById<Button>(R.id.newsfeed)
        newsfeed.setOnClickListener{
            val intent2 = Intent(this,NewsFeed::class.java)
            startActivity(intent2)
        }

        var camps = findViewById<Button>(R.id.camps)
        camps.setOnClickListener{
            val intent3 = Intent(this,BloodCamp::class.java)
            startActivity(intent3)
        }

        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener{
            val intent4 = Intent(this,Donation::class.java)
            startActivity(intent4)
        }

        var btnabout = findViewById<Button>(R.id.btnabout)
        btnabout.setOnClickListener{
            val intent5 = Intent(this,AboutUs::class.java)
            startActivity(intent5)
        }

        var btncontact = findViewById<Button>(R.id.btncontact)
        btncontact.setOnClickListener{
            val intent6 = Intent(this,contactus::class.java)
            startActivity(intent6)
        }
    }
}