package com.example.myfirstapp.data.conection

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object ApiConnection {

    enum class typeApi {
        Marvel
    }


    //lama a la direccion principal,crea la conexion
    private val API_MARVEL = "https://gateway.marvel.com/v1/public/"


    private fun getConnnection(base: String): Retrofit {
        var retrofit = Retrofit.Builder()
            .baseUrl(base)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        return retrofit
    }

    suspend fun <T, E : Enum<E>> getService(api: E, service: Class<T>): T {
        var BASE = ""
        when (api.name) {
            typeApi.Marvel.name -> {
                BASE = API_MARVEL
            }
        }
        return getConnnection(BASE).create(service)
    }
}