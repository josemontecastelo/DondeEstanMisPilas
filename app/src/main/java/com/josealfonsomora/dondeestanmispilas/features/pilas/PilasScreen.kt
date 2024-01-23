package com.josealfonsomora.dondeestanmispilas.features.pilas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PilasScreen(viewModel: PilasViewModel = hiltViewModel()) {
    val state = viewModel.state
    PilasContent(state)
}

@Composable
fun PilasContent(state: List<Pila> = emptyList()) {

    LazyColumn {
        items(state) { pila ->
            Pila(pila)
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
    PilasContent()
}