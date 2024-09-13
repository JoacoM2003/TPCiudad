package com.example.tpciudad.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "ciudades")
data class Ciudad(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    @ColumnInfo("nombre")
    val nombre: String,
    @ColumnInfo("pais")
    val pais: String,
    @ColumnInfo("poblacion")
    val poblacion: String
)
