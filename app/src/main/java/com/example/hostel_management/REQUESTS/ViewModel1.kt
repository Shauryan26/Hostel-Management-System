package com.example.hostel_management.REQUESTS

import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel


import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ViewModel1 : ViewModel() {

    private var movieLiveData= MutableLiveData<List<User>>()
    fun getPopularMovies(){

        ReterofitClient2.api.setType().enqueue(object :

            Callback<requesters> {

            override fun onResponse(call: Call<requesters>, response: Response<requesters>) {
                if(response.body()!=null) {

                    Log.i("NumberGenerated",response.body()!!.error)
                    movieLiveData.value=response.body()!!.users
                }
            }

            override fun onFailure(call: Call<requesters>, t: Throwable) {
                Log.i("Tag","BadyAS")
            }

        })
    }
    fun observeMovieLiveData() : MutableLiveData<List<User>> {
        return movieLiveData
    }


    }
