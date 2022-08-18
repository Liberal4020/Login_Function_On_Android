package com.example.myapplication.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.model.entity.Register
import com.example.myapplication.model.entity.Token
import com.example.myapplication.model.network.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel : ViewModel()  {
    private val repository: UserRepository = UserRepository()
    val register = MutableLiveData<Register>()
    val token = MutableLiveData<Token>()

    fun newUser(name: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result : Register? = repository.newUser(name, password)//epid!!
            register.postValue(result)
        }
    }

    fun logIn(name: String, password: String) {
        viewModelScope.launch(Dispatchers.IO) {
            val result : Token? = repository.logIn(name, password)//epid!!
            token.postValue(result)
        }
    }
}