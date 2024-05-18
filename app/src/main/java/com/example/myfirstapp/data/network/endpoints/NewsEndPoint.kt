package com.example.myfirstapp.data.network.endpoints

import retrofit2.http.GET
import retrofit2.http.Query

interface NewsEndPoint {

    @GET("top")
    suspend fun getAllTopNews(
        @Query("api_token") apiToken: String,
        @Query("locale") locale: String,
        @Query("limit") limit: Int

    )
}