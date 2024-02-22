package com.josealfonsomora.dondeestanmispilas.navigation

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.josealfonsomora.dondeestanmispilas.features.addpilas.addPilasScreen
import com.josealfonsomora.dondeestanmispilas.features.pilas.ROUTE
import com.josealfonsomora.dondeestanmispilas.features.pilas.pilasScreen

@Composable
fun Navigation(modifier: Modifier = Modifier){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = ROUTE){
        pilasScreen(navController = navController)
        addPilasScreen()
    }
}