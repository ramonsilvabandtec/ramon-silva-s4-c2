package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class Register : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
    }

    fun cadastrar(view: View) {
        val etBreed: EditText = findViewById(R.id.et_breed)
        val swKids: Switch = findViewById(R.id.sw_kids)

        val etPreco: EditText = findViewById(R.id.et_price)
        val preçoString: String = etPreco.text.toString()
        val precoDouble: Double = preçoString.toDouble()

        val apiFilmes = Connection.create()

        val dog: Dog = Dog(etBreed.text.toString(), precoDouble, swKids.isChecked)
        apiFilmes.post(dog).enqueue(object : Callback<Void> {
            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(baseContext, "Dog sucessfully registered!", Toast.LENGTH_SHORT).show()
            }

            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Call error: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })
    }
    }
