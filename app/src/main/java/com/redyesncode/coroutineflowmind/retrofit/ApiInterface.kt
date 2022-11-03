package com.redyesncode.coroutineflowmind.retrofit

import com.redyesncode.coroutineflowmind.Constants
import com.redyesncode.coroutineflowmind.models.LoginBody
import com.redyesncode.coroutineflowmind.models.LoginResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiInterface {



    @POST("authJWT")
    fun authJWT(@Body loginBody: LoginBody): LoginResponse
}