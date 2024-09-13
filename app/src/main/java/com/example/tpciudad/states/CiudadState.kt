package com.example.tpciudad.states

import com.example.tpciudad.models.Ciudad

data class CiudadState(
    val ciudades: List<Ciudad> = emptyList()
)
