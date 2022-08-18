package com.example.myapplication.view.activity

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityRegistrationBinding
import com.example.myapplication.viewmodel.UserViewModel

class RegistrationActivity : AppCompatActivity(){
    private lateinit var binding: ActivityRegistrationBinding

    private val userViewModel: UserViewModel by lazy {
        ViewModelProvider.NewInstanceFactory().create(UserViewModel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRegistrationBinding.inflate(layoutInflater)
        binding.register.setOnClickListener { registration() }
        userViewModel.register.observe(this) {
            result ->
                if(result!=null) {
                    finish()
                } else{
                    val toast = Toast.makeText(this, "Registration failed", Toast.LENGTH_SHORT)
                    toast.show()
                }
        }
        setContentView(binding.root)
    }

    private fun registration() {
        userViewModel.newUser(binding.username.text.toString(), binding.password.text.toString())
    }
}