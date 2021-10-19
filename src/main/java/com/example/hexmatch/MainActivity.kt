package com.example.hexmatch

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.content.Intent
import android.util.Log

// got the structure for changing between activities here
// https://developer.android.com/training/basics/firstapp/starting-activity
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.start_Button)
        // finds the start button by id then starts a onclick listener

        button.setOnClickListener{
            //on clicking the button, I declare my intent to change my activity to game
            startActivity(Intent(this@MainActivity,GameActivity::class.java))

        }
    }


    }
