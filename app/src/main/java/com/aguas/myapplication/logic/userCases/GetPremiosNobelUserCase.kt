package com.aguas.myapplication.logic.userCases

import com.aguas.myapplication.data.network.endpoints.PremiosNobelEndpoint
import com.aguas.myapplication.data.network.repository.RetrofitBase
import com.aguas.myapplication.ui.core.toDataPremiosNobelUI
import com.aguas.myapplication.ui.entities.PremiosNobelDataUI


class GetPremiosNobelUserCase {
    suspend operator fun invoke(): Result<List<PremiosNobelDataUI>> {

        var items = ArrayList<PremiosNobelDataUI>()
        var response = RetrofitBase.returnBaseRetrofitPremiosNobel()
            .create(PremiosNobelEndpoint::class.java)
            .getNobelPrizes()
        return if (response.isSuccessful) {
            response.body()?.nobelPrizes?.forEach {
                items.add(it.toDataPremiosNobelUI())
            }
            Result.success(items)
        } else {
            Result.failure(Exception("Error en la API"))
        }
    }
}