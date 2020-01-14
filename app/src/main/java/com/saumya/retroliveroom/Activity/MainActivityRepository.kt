package com.saumya.retroliveroom.Activity

import android.arch.lifecycle.LiveData
import android.util.Log
import com.google.gson.Gson
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import com.saumya.retroliveroom.Model.DeveloperModel
import com.saumya.retroliveroom.Retrofit.RestApi
import com.saumya.retroliveroom.RoomViewModelKotlinSampleApplication

class MainActivityRepository {

    val BASE_URL = "https://github-trending-api.now.sh/"
    val TAG = MainActivityRepository::class.java.simpleName

    fun getDevelopers() : LiveData<List<DeveloperModel>>
    {
        return RoomViewModelKotlinSampleApplication.database!!.developerDao().getAllDevelopers()

    }

    fun ApiCallAndPutInDB()
    {
        val gson = Gson()
        val retrofit =  Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .baseUrl(BASE_URL)
                .build()

        val restApi = retrofit.create<RestApi>(RestApi::class.java)

        restApi.getAllDevelopers().enqueue(object : Callback<List<DeveloperModel>>{

            override fun onFailure(call: Call<List<DeveloperModel>>?, t: Throwable?) {
                Log.e(TAG,"OOPS!! something went wrong..")
            }

            override fun onResponse(call: Call<List<DeveloperModel>>?, response: Response<List<DeveloperModel>>?) {

                Log.e(TAG,response!!.body().toString())
                when(response.code())
                {
                    200 ->{
                        Thread(Runnable {

                            RoomViewModelKotlinSampleApplication.database!!.developerDao()
                            .deleteAllDeveloper()
                            RoomViewModelKotlinSampleApplication.database!!.developerDao()
                            .insertAllDevelopers(response.body()!!)

                        }).start()
                    }
                }

            }
        })


    }
}