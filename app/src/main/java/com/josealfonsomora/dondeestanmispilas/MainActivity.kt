package com.josealfonsomora.dondeestanmispilas

import android.app.Activity
import android.content.Intent
import android.content.pm.PackageManager
import android.net.Uri
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.josealfonsomora.dondeestanmispilas.navigation.Navigation
import com.josealfonsomora.dondeestanmispilas.theme.DondeEstanMisPilasTheme
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import android.provider.Settings
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.josealfonsomora.dondeestanmispilas.di.PilasDataStore
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import javax.inject.Inject


@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    @Inject
    @PilasDataStore
    lateinit var pilasDataStore: DataStore<Preferences>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.d("Lifecycle", "onCreate: ")
//        val dbHelper = PilasDBHelper(this)
//        val writableDB = dbHelper.readableDatabase
//        writableDB.execSQL(
//            """
//                INSERT INTO ${PilasDBScheme.TABLE_NAME}
//                (
//                    ${PilasDBScheme.COLUMN_NAME},
//                    ${PilasDBScheme.COLUMN_DESCRIPTION},
//                    ${PilasDBScheme.COLUMN_TYPE},
//                    ${PilasDBScheme.COLUMN_LOCATION}
//                )
//                VALUES ('Primera Pila', 'Esta es la primera pila', 'AAA', 'Mando TV')
//            """.trimIndent()
//        )
//        val values = ContentValues().apply {
//            put(PilasDBScheme.COLUMN_NAME, "Segunda Pila")
//            put(PilasDBScheme.COLUMN_DESCRIPTION, "Esta es la segunda pila")
//            put(PilasDBScheme.COLUMN_TYPE, "AA")
//            put(PilasDBScheme.COLUMN_LOCATION, "Despertador")
//        }
//        writableDB.insert(PilasDBScheme.TABLE_NAME,null, values)

//        val sharedprefs = this.getSharedPreferences("Shared1", Context.MODE_PRIVATE)
//        sharedprefs.edit().putInt("key1", 1).apply()

//        val sharedPref = this.getPreferences(Context.MODE_PRIVATE) ?: return
//        with (sharedPref.edit()) {
//            putInt(getString(R.string.saved_high_score_key), newHighScore)
//            apply()
//        }

//        sharedprefs.edit().apply{
//            putInt("key1", 1)
//            apply()
//        }
//        val savedShare = sharedprefs.getInt("key1",9)
//        Log.d("Lifecycle", "onCreate: $savedShare")
//        Log.d("Coroutinas", "antes de emprezar")
//        val job = GlobalScope.launch(Dispatchers.Main) {
//            withContext(Dispatchers.Main) {
//                functionThatWaitsOnRunBlocking()
//            }
//        }
//
//        funcionquesepara()
        val EXAMPLE_COUNTER = intPreferencesKey("example_counter")
        val EXAMPLE_COUNTER_2 = intPreferencesKey("example_counter_2")

//        runBlocking {
//            pilasDataStore.edit { preferences ->
//                preferences[EXAMPLE_COUNTER] = 6
//                preferences[EXAMPLE_COUNTER_2] = 16
//            }
//        }
        runBlocking {
            pilasDataStore.data.map { preferences ->
                val saved = preferences[EXAMPLE_COUNTER] ?: 0
                val saved2 = preferences[EXAMPLE_COUNTER_2] ?: 0
                Log.d("PilasRepository", "getPilasFromDataStore: $saved $saved2")
            }.first()
        }
        if(shouldShowRequestPermissionRationale(android.Manifest.permission.CAMERA)){
            Log.d("Permission", "shouldShowRequestPermissionRationale: TRUE ")
        }else{
            Log.d("Permission", "shouldShowRequestPermissionRationale: FALSE ")
//            startActivity(Intent(Settings.ACTION_APPLICATION_DETAILS_SETTINGS, Uri.parse("package:$packageName")))
//            openAppSettings()
        }
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
                    Navigation(
                        modifier = Modifier.padding(padding),
                    )
                }

            }
        }
    }

    override fun onResume() {
        super.onResume()
        Log.d("Lifecycle", "onResume: ")
    }



}

fun Activity.openAppSettings() {
    Intent(
        Settings.ACTION_APPLICATION_DETAILS_SETTINGS,
        Uri.fromParts("package", packageName, null)
    ).also(::startActivity)
}


fun functionThatWaitsOnRunBlocking() {
    runBlocking {
        launch {
            delay(4000) // Simulate some background work
        }
        delay(2000)
    }
}