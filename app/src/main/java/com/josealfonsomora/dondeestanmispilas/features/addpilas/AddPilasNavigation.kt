package com.josealfonsomora.dondeestanmispilas.features.addpilas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val ROUTE = "add_pilas_screen"
fun NavController.navigateToAddPilasScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.addPilasScreen() {
    composable(ROUTE) { AddPilasScreen() }
}