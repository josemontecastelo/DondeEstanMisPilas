package com.josealfonsomora.dondeestanmispilas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import com.josealfonsomora.dondeestanmispilas.di.PilasDataStore
import com.josealfonsomora.dondeestanmispilas.ui.PilasNavigation
import com.josealfonsomora.dondeestanmispilas.ui.theme.DondeEstanMisPilasTheme
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @PilasDataStore
    lateinit var pilasDataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            DondeEstanMisPilasTheme {
                Scaffold(
                    topBar = {},
                    floatingActionButton = {
                        Button(onClick = {

                        }) {

                        }
                    },
                ) { padding ->
                    Box(
                        modifier = Modifier.padding(padding),
                    ) {
                        PilasNavigation()
                    }
                }

            }
        }
    }
}