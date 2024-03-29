package com.josealfonsomora.dondeestanmispilas.ui.addpilas

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.ui.theme.DondeEstanMisPilasTheme

@Composable
fun AddPilasScreen(viewModel: AddPilasViewModel = hiltViewModel()) {
    val state by viewModel.state.collectAsState(0)
    AddPilasContent(addPila = {
        viewModel.guardarPila(it)
    },state= state)
}

@Composable
fun AddPilasContent(
    addPila: (Pila) -> Unit = {},
    state: Int,
) {
    val pila = Pila(
        name = "Tercera Pila", description = "tercera pila", type = "C", location = "mando"
    )

    Box(contentAlignment = androidx.compose.ui.Alignment.Center) {
        Column {

        Text(text = "Pilas en DataStore: $state")
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { addPila(pila) }) {
            Text(text = "Añadir Pila")
        }
        }
    }
}

@Preview
@Composable
fun AddPilasScreenPreview() {
    DondeEstanMisPilasTheme {
        AddPilasContent({},1)
    }
}