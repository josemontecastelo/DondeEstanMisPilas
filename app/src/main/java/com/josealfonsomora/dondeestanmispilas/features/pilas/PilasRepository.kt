package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.util.Log
import com.josealfonsomora.dondeestanmispilas.api.CatFactResponse
import com.josealfonsomora.dondeestanmispilas.api.CatsApi
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.PilaDao
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.toDomain
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.domain.toEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject


class PilasRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
    private val pilaDao: PilaDao,
    private val api: CatsApi
) {
    suspend fun getUser() {

    }

    suspend fun getCatsFact() {
        withContext(Dispatchers.IO) {
            val fact: CatFactResponse = api.getCatFact().await()
            Log.d("PilasRepository", "getCatsFact: $fact")
        }
    }

    suspend fun getPilas(): List<Pila> {
        return withContext(Dispatchers.IO) {
            Log.d("PilasRepository", "getPilas: ")
            val pilas = pilaDao.getAll().map { it.toDomain() }
            Log.d("PilasRepository", "getPilas: FINISHED $pilas")
            pilas
        }
    }

    fun guardarPila(pila: Pila) = pilaDao.insertAll(pila.toEntity())

}