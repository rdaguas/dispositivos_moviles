package com.aguas.myapplication.data.network.endpoints

import com.aguas.myapplication.data.network.entities.NasaData
import retrofit2.Response
import retrofit2.http.GET

interface NasaEndpoint {

    @GET("photos")
    suspend fun getNasaPhotos(): Response<NasaData>

}