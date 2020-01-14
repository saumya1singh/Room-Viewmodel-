package com.saumya.retroliveroom.DB.Room

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import com.saumya.retroliveroom.Model.DeveloperModel

@Dao
interface DeveloperDao {

    @Query("SELECT * FROM Developers")
    fun getAllDevelopers() : LiveData<List<DeveloperModel>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAllDevelopers(developerList: List<DeveloperModel>)

    @Query("DELETE FROM Developers")
    fun deleteAllDeveloper()
}