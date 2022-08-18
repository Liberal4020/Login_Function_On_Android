package com.example.myapplication.util

import android.content.Context

object UserToken {
    var token : String? = null

    fun initUserToken(context: Context) {
        val sharedPref = context.getSharedPreferences("prefname", Context.MODE_PRIVATE)
        token = sharedPref.getString("tokenkey", null)
    }

    fun setUserToken(context: Context, token : String) {
        val sharedPref = context.getSharedPreferences("prefname", Context.MODE_PRIVATE)
        sharedPref.edit().putString("tokenkey", token).apply()
    }

    fun getUserToken() : String {
        return if(token == null) "" else token!!
    }
}