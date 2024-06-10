package com.aguas.myapplication.data.network.repository

import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
object RetrofitBase {

    //https://api.nobelprize.org/2.1/nobelPrizes
        fun returnBaseRetrofitPremiosNobel(): Retrofit {
        return Retrofit.Builder()
            .baseUrl("https://api.nobelprize.org/2.1/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(apiClientPremiosNobel())
            .build()
    }

    private fun apiClientPremiosNobel(): OkHttpClient = OkHttpClient.Builder()
        .addInterceptor(PremiosNobelInterceptor())
        .build()

}