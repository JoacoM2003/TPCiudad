package com.example.tpciudad.viewmodels

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.tpciudad.models.Ciudad
import com.example.tpciudad.room.CiudadDatabaseDao
import com.example.tpciudad.states.CiudadState
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch

class CiudadViewModel(
    private val dao: CiudadDatabaseDao
): ViewModel() {

    var state by mutableStateOf(CiudadState())
        private set


    init {
        viewModelScope.launch {
            dao.obtenerCiudades().collectLatest {
                state = state.copy(
                    ciudades = it
                )
            }
        }
    }

    fun obtenerCiudad(nombre: String) = viewModelScope.launch {
        dao.obtenerCiudad(nombre = nombre)
    }

    fun agregarCiudad(ciudad: Ciudad) = viewModelScope.launch {
        dao.agregarCiudad(ciudad = ciudad)
    }

    fun actualizarCiudad(ciudad: Ciudad) = viewModelScope.launch {
        dao.actualizarCiudad(ciudad = ciudad)
    }

    fun borrarCiudad(ciudad: Ciudad) = viewModelScope.launch {
        dao.borrarCiudad(ciudad = ciudad)
    }

}