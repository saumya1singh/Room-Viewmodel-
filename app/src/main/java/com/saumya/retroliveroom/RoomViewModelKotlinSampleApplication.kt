package com.saumya.retroliveroom

import android.app.Application
import android.arch.persistence.room.Room
import com.saumya.retroliveroom.DB.Room.DeveloperDatabase

class RoomViewModelKotlinSampleApplication : Application() {

    companion object {
        var database: DeveloperDatabase? = null
    }

    override fun onCreate() {
        super.onCreate()
        database =  Room.databaseBuilder(applicationContext, DeveloperDatabase::class.java,
        "developer_db").fallbackToDestructiveMigration().build()
    }
}