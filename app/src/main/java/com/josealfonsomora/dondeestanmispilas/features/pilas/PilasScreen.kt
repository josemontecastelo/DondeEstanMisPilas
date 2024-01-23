@file:OptIn(ExperimentalMaterial3Api::class)

package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.josealfonsomora.dondeestanmispilas.domain.Pila

@Composable
fun PilasScreen(
    viewModel: PilasViewModel = hiltViewModel(),
    navigateToAddPilas: () -> Unit,
) {
    val state = viewModel._state
    PilasContent(
        state.value,
        navigateToAddPilas = navigateToAddPilas
    )
}

@Composable
fun PilasContent(
    state: List<Pila> = emptyList(),
    navigateToAddPilas: () -> Unit,
) {
    Log.d("PilasContent", "PilasContent: $state")
    Column {

        LazyColumn {
            items(state) { pila ->
                Pila(pila)
            }
        }

        Button(onClick = { navigateToAddPilas() }) {
            Text(text = "Añadir Pila")
        }
    }

}

@Composable
fun Pila(pila: Pila) {
    Row {
        Text(pila.name)
        Text(pila.description)
        Text(pila.location)
    }
}

@Preview
@Composable
fun PilasScreenPreview() {
    PilasContent {}
}