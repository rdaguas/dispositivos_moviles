package com.ramos.myapplication.logic.userCases

import com.ramos.myapplication.data.network.endpoints.NewsEndpoint
import com.ramos.myapplication.data.network.repository.RetrofitBase

class GetAllTopsNewUserCase {


    suspend operator fun invoke() {

        var response = RetrofitBase.returnBaseRetrofitNews()
            .create(NewsEndpoint::class.java)
            .getAllTopNews(RetrofitBase.NEWS_API_KEY)

        if (response.isSuccessful) {
            val data = response.body()?.data
        }
    }
}