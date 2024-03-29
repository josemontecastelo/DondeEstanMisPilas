package com.josealfonsomora.dondeestanmispilas.ui.addpilas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.josealfonsomora.dondeestanmispilas.ui.addpilas.AddPilasScreen

val ROUTE = "add_pilas_screen"
fun NavController.navigateToAddPilasScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.addPilasScreen() {
    composable(ROUTE) { AddPilasScreen() }
}