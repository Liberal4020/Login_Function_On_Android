package com.example.myapplication.view.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityLoginBinding
import com.example.myapplication.util.UserToken
import com.example.myapplication.viewmodel.UserViewModel

class LoginActivity : AppCompatActivity(){
    private lateinit var binding: ActivityLoginBinding

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        binding.login.setOnClickListener { login() }
        binding.registration.setOnClickListener { openRegistration() }
        userViewModel.token.observe(this) {
                result ->
            if(result!=null) {
                UserToken.setUserToken(this, result.token)
                val intent: Intent = Intent(this,MainActivity().javaClass)
                startActivity(intent)
                finish()
            } else{
                val toast = Toast.makeText(this, "Login failed", Toast.LENGTH_SHORT)
                toast.show()
            }
        }
        setContentView(binding.root)
    }

    private fun login() {
        userViewModel.logIn(binding.username.text.toString(), binding.password.text.toString())
    }

    private fun openRegistration() {
        val intent: Intent = Intent(this,RegistrationActivity().javaClass)
        startActivity(intent)
    }
}