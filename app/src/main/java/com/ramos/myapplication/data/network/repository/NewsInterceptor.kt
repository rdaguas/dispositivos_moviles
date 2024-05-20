package com.ramos.myapplication.data.network.repository

import okhttp3.Interceptor
import okhttp3.Response

class NewsInterceptor(private val apiKey: String) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {

        val newUrl = chain.request()
            .url().newBuilder()
            .addQueryParameter("api_token", apiKey)
            .build()
        val newRequest = chain.request()
            .newBuilder()
            .url(newUrl)
            .build()
        return chain.proceed(newRequest)
    }
}