package com.josealfonsomora.dondeestanmispilas.features.pilas

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable

val ROUTE = "pilas_screen"
fun NavController.navigateToPilasScreen() {
    navigate(ROUTE)
}
fun NavGraphBuilder.pilasScreen() {
    composable(ROUTE) { PilasScreen() }
}