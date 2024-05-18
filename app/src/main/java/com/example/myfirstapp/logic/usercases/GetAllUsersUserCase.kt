package com.example.myfirstapp.logic.usercases

import android.util.Log
import com.example.myfirstapp.data.network.endpoints.UsersEndpoint
import com.example.myfirstapp.data.network.repository.RetrofitBase

class GetAllUsersUserCase {

    //objeto para una sola llamada es el siguiente método
    suspend operator fun invoke() {
        val call = RetrofitBase.returnBaseRetrofit()
        val service = call.create(UsersEndpoint::class.java)
        val response = service.getAllUsers()
        //devuelve un codigo de ejecucion satisfactoria
        if (response.isSuccessful) {
            val body = response.body()
            Log.d("RSP", body.toString())
        } else {
            Log.d("RSP", "lA EJECUCION FALLO")

        }
    }


}