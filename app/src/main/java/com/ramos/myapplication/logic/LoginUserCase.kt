package com.ramos.myapplication.logic;

import com.ramos.myapplication.data.local.UserClass
import com.ramos.myapplication.data.local.repository.ListUsers
import java.lang.Exception

class LoginUserCase(val listUser: ListUsers) {

    operator fun invoke(user: String, pass: String): Result<UserClass> {

        var us = listUser.checkUserPass(user, pass)

        return if (us != null) {
            Result.success(us)
        } else {
            Result.failure(Exception("Error de user o pass"))
        }
    }
}