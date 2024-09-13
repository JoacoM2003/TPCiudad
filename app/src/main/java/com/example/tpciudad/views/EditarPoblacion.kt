package com.example.tpciudad.views

import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.tpciudad.models.Ciudad
import com.example.tpciudad.viewmodels.CiudadViewModel

@kotlin.OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EditarPoblacion(navController: NavController, viewModel: CiudadViewModel, id: Int, nombre: String?, pais: String?){

    val context = LocalContext.current
    var poblacion by remember { mutableStateOf("") }

    Column (
        modifier = androidx.compose.ui.Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Spacer(modifier = androidx.compose.ui.Modifier.height(60.dp))
        Text("Modificar población de ${nombre}")
        Spacer(modifier = androidx.compose.ui.Modifier.height(30.dp))
        TextField(
            value = poblacion,
            onValueChange = { poblacion = it},
            label = { Text("Población: ") },
            modifier = androidx.compose.ui.Modifier.fillMaxWidth()
        )
        Button(onClick = {
            val nuevaCiudad = Ciudad(id = id, nombre = nombre!!, pais = pais!!, poblacion = poblacion)
            viewModel.actualizarCiudad(nuevaCiudad)
            navController.popBackStack()
            Toast.makeText(context, "Se guardó correctamente", Toast.LENGTH_SHORT).show()
        }) {
            Text(text = "Aceptar")
        }



    }

}