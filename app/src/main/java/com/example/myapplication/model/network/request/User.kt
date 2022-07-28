package com.example.myapplication.model.network.request

import com.example.myapplication.model.entity.Status
import com.example.myapplication.model.entity.Token
import retrofit2.Call

interface User {
    fun NewUser()
    fun LogIn() : Call<Token>
    fun LogOut() : Call<Status>
}