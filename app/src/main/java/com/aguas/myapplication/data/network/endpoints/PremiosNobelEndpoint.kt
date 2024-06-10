package com.aguas.myapplication.data.network.endpoints

import com.aguas.myapplication.data.network.entities.DataPremiosNobel
import retrofit2.Response
import retrofit2.http.GET

interface PremiosNobelEndpoint {

    @GET("nobelPrizes")
    suspend fun getNobelPrizes(): Response<DataPremiosNobel>

}