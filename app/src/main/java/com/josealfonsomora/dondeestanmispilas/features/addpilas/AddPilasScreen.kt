package com.josealfonsomora.dondeestanmispilas.features.addpilas

import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import com.josealfonsomora.dondeestanmispilas.features.pilas.Pila

@Composable
fun AddPilasScreen(viewModel: AddPilasViewModel = hiltViewModel()) {
    AddPilasContent(addPila = {
        viewModel.guardarPila(it)
    })
}

@Composable
fun AddPilasContent(
    addPila: (Pila) -> Unit = {},
) {
    val pila = Pila(
        name = "Tercera Pila", description = "tercera pila", type = "C", location = "mando"

    )
    Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
        Button(onClick = { addPila(pila) }) {
            Text(text = "Añadir Pila")
        }
    }
}