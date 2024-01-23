@file:OptIn(ExperimentalMaterial3Api::class)

package com.josealfonsomora.dondeestanmispilas.features.pilas

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun PilasScreen(
    viewModel: PilasViewModel = hiltViewModel(),
    navigateToAddPilas: () -> Unit,
) {
    val state = viewModel.state
    PilasContent(
        state, navigateToAddPilas = navigateToAddPilas
    )
}

@Composable
fun PilasContent(
    state: List<Pila> = emptyList(),
    navigateToAddPilas: () -> Unit,
) {
    Column {

        var textFieldValue by remember { mutableStateOf("") }
        TextField(value = textFieldValue, onValueChange = {
            textFieldValue = it
        })

        var radiobuttonSelection by remember { mutableStateOf(1) }
        RadioButton(selected = radiobuttonSelection == 1, onClick = { radiobuttonSelection = 1 })
        RadioButton(selected = radiobuttonSelection == 2, onClick = { radiobuttonSelection = 2 })
        RadioButton(selected = radiobuttonSelection == 3, onClick = { radiobuttonSelection = 3 })

        LazyColumn {
            items(state) { pila ->
                Pila(pila)
            }
        }
    }

    Button(onClick = { navigateToAddPilas() }) {
        Text(text = "Añadir Pila")
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
    PilasContent(){}
}