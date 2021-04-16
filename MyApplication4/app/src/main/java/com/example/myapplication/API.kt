package com.example.myapplication

import retrofit2.Call
import retrofit2.http.*
import kotlin.collections.List

interface API {

    @POST("cachorros/")
    fun post(@Body dog: Dog): Call<Void>
    @DELETE("cachorros/{id}")
    fun remove(@Path("id") id: Int): Call<Void>
    @GET("cachorros/")
    fun list(): Call<List<Dog>>
}