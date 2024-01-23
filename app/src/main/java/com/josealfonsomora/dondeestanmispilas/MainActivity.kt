package com.josealfonsomora.dondeestanmispilas

import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.josealfonsomora.dondeestanmispilas.navigation.Navigation
import com.josealfonsomora.dondeestanmispilas.theme.DondeEstanMisPilasTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d("Lifecycle", "onCreate: ")
        setContent {
            DondeEstanMisPilasTheme {
                Scaffold(
                    topBar = {},
                    floatingActionButton = {},
                ) { padding ->
                    Navigation(modifier = Modifier.padding(padding))
                }
            }
        }
    }

}