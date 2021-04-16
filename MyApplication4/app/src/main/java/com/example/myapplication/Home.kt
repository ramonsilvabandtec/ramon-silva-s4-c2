package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Home : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun goRegister(view: View) {
        val intent = Intent(this, Register::class.java).apply {
        }
        startActivity(intent)
    }

    fun List(view: View) {

        val intent = Intent(this, DogList::class.java).apply {
        }
        startActivity(intent)

    }

    }
