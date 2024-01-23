package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.content.ContentValues
import android.database.sqlite.SQLiteDatabase
import com.josealfonsomora.dondeestanmispilas.bd.PilasDBScheme
import javax.inject.Inject

class PilasRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
    private val writableDB: SQLiteDatabase
) {

    fun getPilas(): List<Pila> {
        val cursor = writableDB.query(
            PilasDBScheme.TABLE_NAME, arrayOf(
                PilasDBScheme.COLUMN_NAME,
                PilasDBScheme.COLUMN_DESCRIPTION,
                PilasDBScheme.COLUMN_TYPE,
                PilasDBScheme.COLUMN_LOCATION
            ), null, null, null, null, null
        )
        val pilas = mutableListOf<Pila>()
        with(cursor) {
            while (moveToNext()) {
                pilas.add(
                    Pila(
name = getString(getColumnIndexOrThrow(PilasDBScheme.COLUMN_NAME)),
                        description = getString(getColumnIndexOrThrow(PilasDBScheme.COLUMN_DESCRIPTION)),
                        type = getString(getColumnIndexOrThrow(PilasDBScheme.COLUMN_TYPE)),
                        location = getString(getColumnIndexOrThrow(PilasDBScheme.COLUMN_LOCATION)),
                    )
                )
            }
        }
        cursor.close()
        return pilas.toList()
    }


    fun guardarPila(pila: Pila) {
        val values = ContentValues().apply {
            put(PilasDBScheme.COLUMN_NAME, pila.name)
            put(PilasDBScheme.COLUMN_DESCRIPTION, pila.description)
            put(PilasDBScheme.COLUMN_TYPE, pila.type)
            put(PilasDBScheme.COLUMN_LOCATION, pila.location)
        }
        writableDB.insert(PilasDBScheme.TABLE_NAME, null, values)
    }

}