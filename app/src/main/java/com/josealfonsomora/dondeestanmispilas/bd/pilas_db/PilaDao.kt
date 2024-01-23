package com.josealfonsomora.dondeestanmispilas.bd.pilas_db

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.josealfonsomora.dondeestanmispilas.bd.PilasDBScheme
import com.josealfonsomora.dondeestanmispilas.domain.Pila


@Dao
interface PilaDao {
    @Query("SELECT * FROM PilaEntity")
    fun getAll(): List<PilaEntity>

    @Insert
    fun insertAll(vararg pilas: PilaEntity)

    @Delete
    fun delete(pila: PilaEntity)
}