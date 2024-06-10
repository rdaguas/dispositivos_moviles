package com.ramos.myapplication.data.network.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object RetrofitBase {

    // https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/photos
    fun returnBaseRetrofitNasa(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nasa.gov/mars-photos/api/v1/rovers/curiosity/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClientNasa())
            .build()
    }

    private fun apiClientNasa(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(NasaInterceptor(1000, ApiKeys.API_NASA))
        .build()

}