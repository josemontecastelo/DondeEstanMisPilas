package com.josealfonsomora.dondeestanmispilas.bd.pilas_db

import androidx.room.Database
import androidx.room.RoomDatabase

const val DATABASE_VERSION = 1

@Database(entities = [PilaEntity::class], version = DATABASE_VERSION)
abstract class PilasDBRoom : RoomDatabase() {
    abstract fun pilaDao(): PilaDao
}