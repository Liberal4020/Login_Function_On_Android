package com.example.myapplication.model.network.request

import com.example.myapplication.model.entity.Register
import com.example.myapplication.model.entity.Status
import com.example.myapplication.model.entity.Token
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.POST
import retrofit2.http.PUT

interface UserRequest {
    @FormUrlEncoded
    @PUT("users")
    fun NewUser(
        @Field("name") name : String,
        @Field("password") password : String
    ) : Call<Register>

    @FormUrlEncoded
    @POST("users")
    fun LogIn(
        @Field("name") name : String,
        @Field("password") password : String
    ) : Call<Token>
    fun LogOut() : Call<Status>
}