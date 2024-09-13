package com.example.tpciudad.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tpciudad.models.Ciudad
import kotlinx.coroutines.flow.Flow

@Dao
interface CiudadDatabaseDao {

    @Query("SELECT * FROM ciudades")
    fun obtenerCiudades(): Flow<List<Ciudad>>

    @Query("SELECT * FROM ciudades WHERE nombre = :nombre")
    fun obtenerCiudad(nombre: String): Ciudad

    @Insert
    suspend fun agregarCiudad(ciudad: Ciudad)

    @Update
    suspend fun actualizarCiudad(ciudad: Ciudad)

    @Delete
    suspend fun borrarCiudad(ciudad: Ciudad)

}