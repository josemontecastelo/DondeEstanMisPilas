package com.josealfonsomora.dondeestanmispilas.data.sources.room

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query


@Dao
interface PilaDao {
    @Query("SELECT * FROM PilaEntity")
    fun getAll(): List<PilaEntity>

    @Insert
    fun insertAll(vararg pilas: PilaEntity)

    @Delete
    fun delete(pila: PilaEntity)
}