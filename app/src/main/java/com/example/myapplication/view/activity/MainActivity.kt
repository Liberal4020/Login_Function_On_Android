package com.example.myapplication.view.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.myapplication.databinding.ActivityMainBinding
import com.example.myapplication.util.APIClient
import com.example.myapplication.util.UserToken

class MainActivity :  AppCompatActivity(){
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        APIClient.initInterceptor()

        UserToken.initUserToken(this)
        if(UserToken.token==null) {
            val intent: Intent = Intent(this,LoginActivity().javaClass)
            startActivity(intent)
            finish()
        }

        setContentView(binding.root)
    }
}