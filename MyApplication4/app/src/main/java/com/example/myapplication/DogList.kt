package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.Toast
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.collections.List

class DogList<T> : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val text: LinearLayout = findViewById(R.id.layout_lista)

        val api = Connection.create()
        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)
        api.listDogs().enqueue(object : Callback<List<Dog>> {

            override fun onResponse(call: Call<List<Dog>>, response: Response<List<Dog>>) {

                response.body()?.forEach {
                    val tvDog = TextView(baseContext)
                    tvDog.text = "Breed: ${it.breed} - price: ${it.price} - for kids ${it.forKids}"
                    layoutLista.addView(tvDog)
                }
            }

            override fun onFailure(call: Call<List<Dog>>, t: Throwable) {
                Toast.makeText(baseContext, "Call error: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}