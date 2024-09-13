package com.example.tpciudad.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tpciudad.models.Ciudad
import com.example.tpciudad.viewmodels.CiudadViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ModificarPoblacion(navController: NavController, viewModel: CiudadViewModel){
    var nombre by remember { mutableStateOf("") }
    var poblacion by remember { mutableStateOf("") }
    var validar: Int
    val context = LocalContext.current

    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = Modifier.height(60.dp))
        Text(
            text = "Modificar Población",
            fontSize = 20.sp,
            modifier = Modifier
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = nombre,
            onValueChange = { nombre = it},
            label = { Text("Ciudad: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(30.dp))
        TextField(
            value = poblacion,
            onValueChange = { poblacion = it},
            label = { Text("Población: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Row (
            modifier = Modifier
                .fillMaxSize(),
            horizontalArrangement = Arrangement.Center,
            verticalAlignment = Alignment.CenterVertically
        ){
            Button(onClick = {
                validar = validarNombre(nombre = nombre)
                if (validar == 0){
                    Toast.makeText(context, "No pueden ser vacíos", Toast.LENGTH_SHORT).show()
                } else{
                    val flag = BuscarCiudad(nombre = nombre, poblacion = poblacion, viewModel = viewModel)
                    if(flag == true) {
                        navController.popBackStack()
                        Toast.makeText(context, "Se modificó correctamente", Toast.LENGTH_SHORT)
                            .show()
                    } else{
                        Toast.makeText(context, "No hay ciudad con ese nombre", Toast.LENGTH_SHORT)
                            .show()
                    }
                }
            },
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
            ) {
                Text(text = "Aceptar")
            }
            Spacer(modifier = Modifier.width(30.dp))
            Button(onClick = {
                navController.navigate("inicio")
            },
                modifier = Modifier
                    .height(60.dp)
                    .width(150.dp)
            ) {
                Text(text = "Volver")
            }
        }
    }
}

fun BuscarCiudad(nombre: String, poblacion: String, viewModel: CiudadViewModel): Boolean {
    val state = viewModel.state
    val ciudades = state.ciudades
    var flag = false
    for (i in ciudades){
        if(i.nombre == nombre){
            val ciudadObtenida = i
            val nuevaCiudad = Ciudad(id = ciudadObtenida.id, nombre = ciudadObtenida.nombre!!, pais = ciudadObtenida.pais!!, poblacion = poblacion!!)
            viewModel.actualizarCiudad(nuevaCiudad)
            flag = true
            break
        }
    }
    return flag
}