package com.aguas.myapplication.data.network.repository

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class NasaInterceptor(
    private val sol: Int,
//    private val camera: String,
//    private val page: Int,
    private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val request = chain.request()
        val url = request
            .url.newBuilder()
            .addQueryParameter("sol", sol.toString())
//            .addQueryParameter("camera", camera)
//            .addQueryParameter("page", page.toString())
            .addQueryParameter("api_key", apiKey)
            .build()

        val newRequest = request.newBuilder().url(url).build()

        Log.d("TAG", newRequest.url.toString())
        return chain.proceed(newRequest)
    }
}