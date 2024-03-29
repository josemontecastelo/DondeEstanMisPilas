package com.josealfonsomora.dondeestanmispilas.ui.pilas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import androidx.navigation.compose.composable
import com.josealfonsomora.dondeestanmispilas.ui.addpilas.navigateToAddPilasScreen
import com.josealfonsomora.dondeestanmispilas.ui.pilas.PilasScreen

val ROUTE = "pilas_screen"
fun NavController.navigateToPilasScreen() {
    navigate(com.josealfonsomora.dondeestanmispilas.ui.addpilas.ROUTE)
}
fun NavGraphBuilder.pilasScreen(navController: NavHostController) {
    composable(com.josealfonsomora.dondeestanmispilas.ui.addpilas.ROUTE) { PilasScreen(
        navigateToAddPilas = { navController.navigateToAddPilasScreen() }
    ) }
}