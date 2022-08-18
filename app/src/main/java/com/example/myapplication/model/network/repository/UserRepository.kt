package com.example.myapplication.model.network.repository

import com.example.myapplication.model.entity.Register
import com.example.myapplication.model.entity.Token
import com.example.myapplication.model.network.request.UserRequest
import com.example.myapplication.util.APIClient

class UserRepository {
    private var request: UserRequest = APIClient.retrofit.create(UserRequest::class.java)

    fun newUser(name : String, password : String) : Register? {
        try {
            val response = request.NewUser(name, password).execute()
            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun logIn(name : String, password : String) : Token? {
        try {
            val response = request.LogIn(name, password).execute()
            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}