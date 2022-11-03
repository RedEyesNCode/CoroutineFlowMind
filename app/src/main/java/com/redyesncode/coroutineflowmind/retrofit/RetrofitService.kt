package com.redyesncode.coroutineflowmind.retrofit

import com.redyesncode.coroutineflowmind.Constants
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitService {

    // Adding the sample url here !
    val SAMPLE_URL = Constants.RETROFIT_ENDPOINT


    // Making the retrofit client for calling the api's
    val retrofitClient: Retrofit.Builder by lazy {
        val okHttpClient = OkHttpClient.Builder()
        Retrofit.Builder().baseUrl(SAMPLE_URL).client(okHttpClient.build()).addConverterFactory(
            GsonConverterFactory.create())
    }


    // We need the api interface object as well in order to call the apis.

    val apiInterface:ApiInterface by lazy {
        retrofitClient.build().create(ApiInterface::class.java)
    }

}