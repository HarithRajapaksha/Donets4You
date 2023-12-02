package com.example

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.myapplication.R

class NewsFeed : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_news_feed)

        var button6 = findViewById<Button>(R.id.button6)
        button6.setOnClickListener{
            val intent1 = Intent(this,AddNews::class.java)
            startActivity(intent1)
        }

        var button12 = findViewById<Button>(R.id.button12)
        button12.setOnClickListener{
            val intent1 = Intent(this,Dashboard::class.java)
            startActivity(intent1)
        }
    }
}