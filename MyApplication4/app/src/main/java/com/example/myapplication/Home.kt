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

        val api = Connection.create()

        val layoutLista: LinearLayout = findViewById(R.id.layout_lista)

        api.list().enqueue(object : Callback<List<Dog>> {

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

    fun remover(view: View) {
        val API = Connection.create()
        val aqueleId: EditText = findViewById(R.id.id_remover)
        val idString: String = aqueleId.text.toString()
        val idInt: Int = idString.toInt()
        API.remove(idInt).enqueue(object : Callback<Void> {

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                Toast.makeText(baseContext,"REMOVEU",Toast.LENGTH_SHORT).show()
                }
            override fun onFailure(call: Call<Void>, t: Throwable) {
                Toast.makeText(baseContext, "Call error: ${t.message!!}", Toast.LENGTH_SHORT).show()
            }
            })



        }
    }
