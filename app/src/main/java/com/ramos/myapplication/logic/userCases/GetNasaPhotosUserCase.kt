package com.ramos.myapplication.logic.userCases

import com.ramos.myapplication.data.network.endpoints.NasaEndpoint
import com.ramos.myapplication.data.network.repository.RetrofitBase
import com.ramos.myapplication.ui.core.toNasaDataUI
import com.ramos.myapplication.ui.entities.NasaDataUI

//import com.ramos.myapplication.ui.core.toApodNasaDataUI

class GetNasaPhotosUserCase {
    suspend operator fun invoke(): Result<List<NasaDataUI>> {

        var items = ArrayList<NasaDataUI>()
        var response = RetrofitBase.returnBaseRetrofitNasa()
            .create(NasaEndpoint::class.java)
            .getNasaPhotos()
        return if (response.isSuccessful) {
            response.body()?.photos?.forEach {
                items.add(it.toNasaDataUI())
            }
            Result.success(items)
        } else {
            Result.failure(Exception("Error en la API"))
        }
    }
}