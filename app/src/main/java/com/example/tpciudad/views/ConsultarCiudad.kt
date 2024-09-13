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
import com.example.tpciudad.viewmodels.CiudadViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ConsultarCiudad(navController: NavController, viewModel: CiudadViewModel){
    var nombre by remember { mutableStateOf("") }
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
            text = "Consultar Ciudad",
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
        MostrarDatos(navController = navController, nombre = nombre, viewModel = viewModel)
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

@Composable
fun MostrarDatos(navController: NavController, nombre: String,viewModel: CiudadViewModel){
    val state = viewModel.state
    val ciudades = state.ciudades
    for (i in ciudades){
        if(i.nombre == nombre){
            val ciudadObtenida = i
            Text(ciudadObtenida.nombre)
            Text(ciudadObtenida.pais)
            Text(ciudadObtenida.poblacion)
            Spacer(modifier = Modifier.height(10.dp))
            Button(onClick = {
                navController.navigate("editarPoblacion/${ciudadObtenida.id}/${ciudadObtenida.nombre}/${ciudadObtenida.pais}")
            }) {
                Text(text = "Editar")
            }
        }
    }
}


fun validarNombre(nombre: String): Int {
    if (nombre == "") {
        return 0
    }
    return 1
}