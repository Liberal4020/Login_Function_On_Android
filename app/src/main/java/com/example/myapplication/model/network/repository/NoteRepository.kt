package com.example.myapplication.model.network.repository

import com.example.myapplication.model.entity.Note
import com.example.myapplication.model.entity.Status
import com.example.myapplication.model.network.request.NoteRequest
import com.example.myapplication.util.APIClient

class NoteRepository {
    private var request: NoteRequest = APIClient.retrofit.create(NoteRequest::class.java)

    fun getNotes() : Array<Note>? {
        try {
            val response = request.GetNotes().execute()
            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }

    fun postNotes(title: String, body: String, user_id: String) : Status? {
        try {
            val response = request.PostNote(title, body, user_id).execute()
            if (response.isSuccessful) {
                return response.body()
            }
        } catch (e: Exception) {
            e.printStackTrace()
        }
        return null
    }
}
