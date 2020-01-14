package com.saumya.retroliveroom.Retrofit

import retrofit2.Call
import retrofit2.http.GET
import com.saumya.retroliveroom.Model.DeveloperModel

interface RestApi {

    @GET("developers")
    fun getAllDevelopers() : Call<List<DeveloperModel>>
}