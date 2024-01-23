package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.util.Log
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.PilaDao
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.toDomain
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.domain.toEntity
import javax.inject.Inject

class PilasRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
    private val pilaDao: PilaDao
) {

    fun getPilas(): List<Pila> {
        Log.d("PilasRepository", "getPilas: ")
        val pilas = pilaDao.getAll().map { it.toDomain() }
        Log.d("PilasRepository", "getPilas: FINISHED $pilas")
        return pilas
    }

    fun guardarPila(pila: Pila) = pilaDao.insertAll(pila.toEntity())

}