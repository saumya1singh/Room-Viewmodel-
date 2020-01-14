package com.saumya.retroliveroom.DB.Room

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import com.saumya.retroliveroom.Model.DeveloperModel

@Database(entities = [(DeveloperModel::class)], version = 3)
abstract class DeveloperDatabase : RoomDatabase(){

    abstract fun developerDao() : DeveloperDao
}


