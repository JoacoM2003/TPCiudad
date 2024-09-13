package com.example.tpciudad

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.ui.Modifier
import androidx.room.Room
import com.example.tpciudad.navigation.NavManager
import com.example.tpciudad.room.CiudadDatabase
import com.example.tpciudad.ui.theme.TPCiudadTheme
import com.example.tpciudad.viewmodels.CiudadViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TPCiudadTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    val database = Room.databaseBuilder(this, CiudadDatabase::class.java, "db_ciudad").build()
                    val dao = database.ciudadDao()
                    
                    val viewModel = CiudadViewModel(dao)
                    
                    NavManager(viewModel = viewModel)
                }
            }
        }
    }
}
