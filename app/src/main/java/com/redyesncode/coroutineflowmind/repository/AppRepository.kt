package com.redyesncode.coroutineflowmind.repository

import android.util.Log
import com.redyesncode.coroutineflowmind.models.LoginBody
import com.redyesncode.coroutineflowmind.models.LoginResponse
import com.redyesncode.coroutineflowmind.retrofit.RetrofitService
import com.redyesncode.coroutineflowmind.utils.Resource
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import retrofit2.Call

class AppRepository {

    // You can also call the suspend functions directly in the ApiInterface.kt interface class as well.
    suspend fun loginUserCoroutinesXFlow(loginBody: LoginBody) = RetrofitService().apiInterface.authJWT(loginBody)

    // Why non_suspended function are being called inside the suspended functions.


     fun authJWT(loginBody: LoginBody): Flow<Resource<LoginResponse>> = flow {
        //loading
        emit(Resource.loading())
        //sucess
        val data = coroutineScope {
//            RetrofitService().apiInterface.authJWT(loginBody)
            loginUserCoroutinesXFlow(loginBody)
        }
        emit(Resource.success(data))

    }.catch {
        //failure

        Log.i("~~~~~222~~~~~", "authJWT: "+it.message.toString())
        emit(Resource.failed(it.message.toString()))

    }.flowOn(Dispatchers.IO)


}