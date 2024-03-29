package com.josealfonsomora.dondeestanmispilas.data.repositories

import android.util.Log
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.intPreferencesKey
import com.josealfonsomora.dondeestanmispilas.data.sources.network.CatFactResponse
import com.josealfonsomora.dondeestanmispilas.data.sources.network.CatsApi
import com.josealfonsomora.dondeestanmispilas.data.sources.room.PilaDao
import com.josealfonsomora.dondeestanmispilas.data.sources.room.toDomain
import com.josealfonsomora.dondeestanmispilas.di.PilasDataStore
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import retrofit2.await
import javax.inject.Inject


class PilasRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
    @PilasDataStore private val pilasDataStore: DataStore<Preferences>,
    private val pilaDao: PilaDao,
    private val api: CatsApi
) {
    val EXAMPLE_COUNTER = intPreferencesKey("example_counter")

    // At the top level of your kotlin file:
    suspend fun getPilasFromDataStore(): Flow<Int> =
        pilasDataStore.data.map { preferences ->
            Log.d("PilasRepository", "getPilasFromDataStore: ${preferences[EXAMPLE_COUNTER]}")
        // No type safety.
        preferences[EXAMPLE_COUNTER] ?: 0
    }

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

    suspend fun guardarPila(pila: Pila) {
//        pilaDao.insertAll(pila.toEntity())
        pilasDataStore.edit { settings ->
            val currentCounterValue = settings[EXAMPLE_COUNTER] ?: 0
            settings[EXAMPLE_COUNTER] = currentCounterValue + 1
        }
    }

}