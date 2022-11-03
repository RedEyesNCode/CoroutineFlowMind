package com.redyesncode.coroutineflowmind.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.redyesncode.coroutineflowmind.models.LoginResponse
import com.redyesncode.coroutineflowmind.utils.Resource
import androidx.lifecycle.*
import com.redyesncode.coroutineflowmind.models.LoginBody
import com.redyesncode.coroutineflowmind.repository.AppRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class SampleViewModel :ViewModel() {

    private val appRepository:AppRepository
        get() = AppRepository()
    // If you want to remove the use of the local repository then you need
    // to implement the use of the view_model factory as well in the project.


    private val _mutableLiveData = MutableLiveData<Resource<LoginResponse>>()
    val _liveData : LiveData<Resource<LoginResponse>>
        get() = _mutableLiveData



    fun callAuthJWTByFlow(loginBody: LoginBody){
        // loginModel = LoginModel("bhup123456@gmail.com","pistol")
        viewModelScope.launch {
            appRepository.authJWT(loginBody).collect{
                _mutableLiveData.value = it
            }
        }
    }


}