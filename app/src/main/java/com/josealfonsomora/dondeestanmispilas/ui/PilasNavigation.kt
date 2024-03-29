package com.josealfonsomora.dondeestanmispilas.ui

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.josealfonsomora.dondeestanmispilas.ui.addpilas.addPilasScreen
import com.josealfonsomora.dondeestanmispilas.ui.pilas.pilasScreen

@Composable
fun PilasNavigation(){

    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = com.josealfonsomora.dondeestanmispilas.ui.addpilas.ROUTE){
        pilasScreen(navController = navController)
        addPilasScreen()
    }
}