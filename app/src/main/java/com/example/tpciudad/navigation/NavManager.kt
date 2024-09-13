package com.example.tpciudad.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.tpciudad.viewmodels.CiudadViewModel
import com.example.tpciudad.views.AgregarCiudad
import com.example.tpciudad.views.BorrarCiudad
import com.example.tpciudad.views.BorrarPais
import com.example.tpciudad.views.ConsultarCiudad
import com.example.tpciudad.views.EditarPoblacion
import com.example.tpciudad.views.Inicio
import com.example.tpciudad.views.ModificarPoblacion

@Composable
fun NavManager(viewModel: CiudadViewModel) {

    val navController = rememberNavController()

    NavHost(navController = navController, startDestination = "inicio") {
        composable("inicio") {
            Inicio(navController, viewModel)
        }
        composable("agregarCiudad") {
            AgregarCiudad(navController, viewModel)
        }
        composable("consultarCiudad") {
            ConsultarCiudad(navController, viewModel)
        }
        composable("borrarCiudad") {
            BorrarCiudad(navController, viewModel)
        }
        composable("borrarPais") {
            BorrarPais(navController, viewModel)
        }
        composable("modificarPoblacion") {
            ModificarPoblacion(navController, viewModel)
        }
        composable("editarPoblacion/{id}/{nombre}/{pais}", arguments = listOf(
            navArgument("id") { type = NavType.IntType },
            navArgument("nombre") { type = NavType.StringType },
            navArgument("pais") { type = NavType.StringType }
        )) {
            EditarPoblacion(
                navController,
                viewModel,
                it.arguments!!.getInt("id"),
                it.arguments?.getString("nombre"),
                it.arguments?.getString("pais")
            )
        }
    }
}