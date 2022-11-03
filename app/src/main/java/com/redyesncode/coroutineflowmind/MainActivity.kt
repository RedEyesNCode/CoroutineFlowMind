package com.redyesncode.coroutineflowmind

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.redyesncode.coroutineflowmind.databinding.ActivityMainBinding
import com.redyesncode.coroutineflowmind.models.LoginBody
import com.redyesncode.coroutineflowmind.repository.AppRepository
import com.redyesncode.coroutineflowmind.utils.Resource
import com.redyesncode.coroutineflowmind.viewmodel.SampleViewModel

class MainActivity : AppCompatActivity() {

    private lateinit var sampleViewModel:SampleViewModel
    private lateinit var binding:ActivityMainBinding



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)





        setUpFlowAndViewModel()
        binding.btnCallApi.setOnClickListener {
            var loginBody = LoginBody("00001","00001")
            sampleViewModel.callAuthJWTByFlow(loginBody)

        }

    }

    private fun setUpFlowAndViewModel() {
        var appRepository = AppRepository()

        sampleViewModel = ViewModelProvider(this).get(SampleViewModel::class.java)

        sampleViewModel._liveData.observe(this, Observer {

            when(it){
                is Resource.Loading->{
                      Log.d("Load", "onCreate: $it")
                }
                is Resource.Failed->{
                    binding.tvApiData.setText("FAILED ---> $it")

                    Log.d("Fail", "onCreate: $it")
                }
                is Resource.Success->{
                    binding.tvApiData.setText("Success From Api data is ---> "+Gson().toJson(it.data))
                     Log.d("Success", "onCreate: $it")
                }
            }


        })
        var loginBody = LoginBody("00001","00001")


        // Calling the api now.

        sampleViewModel.callAuthJWTByFlow(loginBody)


    }
}