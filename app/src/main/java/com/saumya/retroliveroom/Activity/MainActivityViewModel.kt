package com.saumya.retroliveroom.Activity

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.saumya.retroliveroom.Model.DeveloperModel

class MainActivityViewModel : ViewModel() {

    lateinit var mainActivityRepository: MainActivityRepository

    init {
        mainActivityRepository = MainActivityRepository()
    }

    fun getAllDeveloperList(): LiveData<List<DeveloperModel>>
    {
        return mainActivityRepository.getDevelopers()
    }

    fun getDeveloperFromAPIAndStore()
    {
        mainActivityRepository.ApiCallAndPutInDB()
    }


}