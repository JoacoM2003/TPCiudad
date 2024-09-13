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
fun AgregarCiudad(navController: NavController, viewModel: CiudadViewModel){
    var pais by remember { mutableStateOf("") }
    var ciudad by remember { mutableStateOf("") }
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
            text = "Agregar Ciudad",
            fontSize = 20.sp,
            modifier = Modifier
        )
        Spacer(Modifier.height(30.dp))
        TextField(
            value = pais,
            onValueChange = { pais = it},
            label = { Text("Pais: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(30.dp))
        TextField(
            value = ciudad,
            onValueChange = { ciudad = it},
            label = { Text("Ciudad: ") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(Modifier.height(30.dp))
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
                validar = validarDatos(pais = pais, ciudad = ciudad, poblacion = poblacion)
                if (validar == 0){
                    Toast.makeText(context, "No pueden ser vacíos", Toast.LENGTH_SHORT).show()
                } else{
                    val nuevaCiudad = Ciudad(nombre = ciudad, pais = pais, poblacion = poblacion)
                    viewModel.agregarCiudad(nuevaCiudad)
                    navController.popBackStack()
                    Toast.makeText(context, "Se guardó correctamente", Toast.LENGTH_SHORT).show()
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


fun validarDatos(pais: String, ciudad: String, poblacion: String): Int {
    if (pais == "" || ciudad == "" || poblacion == "") {
        return 0
    }
    return 1
}