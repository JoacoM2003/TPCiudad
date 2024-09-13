package com.example.tpciudad.room

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.tpciudad.models.Ciudad

@Database(
    entities = [Ciudad::class],
    version = 1,
    exportSchema = false
)
abstract class CiudadDatabase: RoomDatabase() {
    abstract fun ciudadDao(): CiudadDatabaseDao
}