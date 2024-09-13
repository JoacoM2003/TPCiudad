package com.example.tpciudad.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.tpciudad.viewmodels.CiudadViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Inicio(navController: NavController, viewModel: CiudadViewModel){
    Column (
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(Modifier.height(60.dp))
        Text(
            text = "Ciudades",
            fontSize = 40.sp,
            modifier = Modifier
        )
        Spacer(Modifier.height(60.dp), )
        Button(onClick = {
            navController.navigate("agregarCiudad")
        },
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
        ) {
            Text("Agregar Ciudad")
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate("consultarCiudad")
        },
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
        ) {
            Text("Consultar Ciudad")
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate("borrarCiudad")
        },
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
        ) {
            Text("Borrar Ciudad")
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate("borrarPais")
        },
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
        ) {
            Text("Borrar País")
        }
        Spacer(Modifier.height(30.dp))
        Button(onClick = {
            navController.navigate("modificarPoblacion")
        },
            modifier = Modifier
                .height(60.dp)
                .width(250.dp)
        ) {
            Text("Modificar Población")
        }
    }
}