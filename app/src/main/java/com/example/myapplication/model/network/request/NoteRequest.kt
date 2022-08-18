package com.example.myapplication.model.network.request

import com.example.myapplication.model.entity.Status
import com.example.myapplication.model.entity.Note
import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.PUT

interface NoteRequest {
    @GET("notes")
    fun GetNotes() : Call<Array<Note>>
    @FormUrlEncoded
    @PUT("notes")
    fun PostNote(
        @Field("title") title : String,
        @Field("body") body : String,
        @Field("user_id") user_id : String
        ) : Call<Status>
}