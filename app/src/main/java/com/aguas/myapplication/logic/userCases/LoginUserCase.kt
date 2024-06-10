package com.aguas.myapplication.logic.usercases

import com.aguas.myapplication.data.local.UserClass
import com.aguas.myapplication.data.local.repository.ListUsers


class LoginUserCase(private val listUser: ListUsers) {
    operator fun invoke(
        user: String,
        password: String
    ): Result<UserClass> {

        var re: Result<UserClass>? = null
        val us = listUser.checkUserPassword2(user, password)

        us.onFailure { re = Result.failure(it) }
        us.onSuccess { re = Result.success(it) }

        return re!!
    }
}