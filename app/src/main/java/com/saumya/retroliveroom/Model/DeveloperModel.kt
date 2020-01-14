package com.saumya.retroliveroom.Model

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = "Developers")
data class DeveloperModel (

        @PrimaryKey
        var username : String,
        var url : String,
        var avatar : String
        

)
