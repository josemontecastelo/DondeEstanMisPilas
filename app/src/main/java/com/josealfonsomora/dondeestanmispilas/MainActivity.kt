package com.josealfonsomora.dondeestanmispilas

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import com.josealfonsomora.dondeestanmispilas.bd.PilasDBHelper
import com.josealfonsomora.dondeestanmispilas.bd.PilasDBScheme
import com.josealfonsomora.dondeestanmispilas.navigation.Navigation
import com.josealfonsomora.dondeestanmispilas.theme.DondeEstanMisPilasTheme
import dagger.hilt.android.AndroidEntryPoint

@ExperimentalMaterial3Api
@AndroidEntryPoint
class MainActivity : ComponentActivity() {
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