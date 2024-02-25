package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.app.Activity
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.core.app.ActivityCompat.requestPermissions
import androidx.hilt.navigation.compose.hiltViewModel
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import kotlinx.coroutines.flow.receiveAsFlow

@Composable
fun PilasScreen(
    viewModel: PilasViewModel = hiltViewModel(),
    navigateToAddPilas: () -> Unit,
) {
    val state = viewModel.state.collectAsState(PilasState.Loading)

    val context = LocalContext.current


        val cameraLauncher =
            rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {}
    val channelMessage = viewModel.channel.receiveAsFlow().collectAsState(initial = "No message")
    LaunchedEffect(key1 = Unit) {
        when (channelMessage.value) {
            "openCamera" -> cameraLauncher.launch(Uri.EMPTY)
            else -> Unit
        }
    }
//    Toast.makeText(context, channelMessage.value, Toast.LENGTH_SHORT).show()

    when (val value = state.value) {
        is PilasState.Loading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        }

        is PilasState.Success -> {
            PilasContent(value.pilas, navigateToAddPilas, onCameraPermissionGranted = {
                viewModel.onCameraPermissionGranted()
            })
        }
    }
}

@Composable
fun PilasContent(
    state: List<Pila> = emptyList(),
    navigateToAddPilas: () -> Unit,
    onCameraPermissionGranted: () -> Unit
) {
    Log.d("PilasContent", "PilasContent: $state")
    val context = LocalContext.current
    val cameraLauncher =
        rememberLauncherForActivityResult(ActivityResultContracts.TakePicture()) {}
    val cameraPermissionResultLauncher = rememberLauncherForActivityResult(
        contract = ActivityResultContracts.RequestPermission(),
        onResult = { isGranted ->
            if (isGranted) {
                onCameraPermissionGranted()
//                cameraLauncher.launch(Uri.EMPTY)
            }
        })

    Column {

        LazyColumn {
            items(state) { pila ->
                Pila(pila)
            }
        }

        Button(onClick = {
            navigateToAddPilas()

        }) {
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
    PilasContent(state = listOf(), navigateToAddPilas = {}, onCameraPermissionGranted = {}) 
}