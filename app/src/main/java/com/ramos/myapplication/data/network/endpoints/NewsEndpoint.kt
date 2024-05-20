package com.ramos.myapplication.data.network.endpoints

import com.ramos.myapplication.data.network.entities.allnews.AllNews
import com.ramos.myapplication.data.network.entities.topNews.NewsApi
import retrofit2.Response
import retrofit2.http.GET

interface NewsEndpoint {
    @GET("top")
    suspend fun getAllTopNews(key: String): Response<NewsApi>
    @GET("all")
    suspend fun getAllNews(): Response<AllNews>
}


//    @GET("top")
//    suspend fun getAllTopNews(@Query("api_token") apiToken: String,
//                              @Query("locale")locale: String,
//                              @Query("limit")limit: Int)


