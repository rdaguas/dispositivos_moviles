package com.example.myfirstapp.logic.usercases

import com.example.myfirstapp.data.UserClass
import com.example.myfirstapp.data.repository.ListUsers

class LoginUserCase (val listUser: ListUsers) {

    operator fun invoke(
        user: String,
        password: String
    ): Result<UserClass> {

        var us = listUser.checkUserPassword(user, password)

        return if (us != null) {
            Result.success(us)
        } else {
            Result.failure(Exception("Error de usario o contraseña"))
        }
    }
}
