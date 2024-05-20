package com.ramos.myapplication.logic.userCases

import android.util.Log
import com.ramos.myapplication.data.network.endpoints.UserEndpoint
import com.ramos.myapplication.data.network.repository.RetrofitBase

class GetAllUsersUserCase {

    suspend operator fun invoke(): Boolean{
        val call = RetrofitBase.returnBaseRetrofit()
        val service = call.create(UserEndpoint::class.java)
        val response = service.getAllUsers()

        return if(response.isSuccessful){
            val body =response.body()
            Log.d("RSP", body.toString())
            true
        }else{
            Log.d("RSP", "La ejecucion fallo")
            false
        }
    }



}