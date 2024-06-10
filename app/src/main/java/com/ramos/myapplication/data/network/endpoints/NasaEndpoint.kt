package com.ramos.myapplication.data.network.endpoints

import com.ramos.myapplication.data.network.entities.NasaData
import com.ramos.myapplication.data.network.entities.Photo
import retrofit2.Response
import retrofit2.http.GET

interface NasaEndpoint {

    @GET("photos")
    suspend fun getNasaPhotos(): Response<NasaData>

}