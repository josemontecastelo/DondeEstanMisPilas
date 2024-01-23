package com.josealfonsomora.dondeestanmispilas.features.pilas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.josealfonsomora.dondeestanmispilas.features.addpilas.navigateToAddPilasScreen

val ROUTE = "pilas_screen"
fun NavController.navigateToPilasScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.pilasScreen(navController: NavHostController) {
    composable(ROUTE) { PilasScreen(
        navigateToAddPilas = { navController.navigateToAddPilasScreen() }
    ) }
}