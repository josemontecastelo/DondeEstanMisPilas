package com.josealfonsomora.dondeestanmispilas.bd.pilas_db

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.josealfonsomora.dondeestanmispilas.domain.Pila

@Entity
class PilaEntity (
    @PrimaryKey
    val name: String,
    @ColumnInfo(name = "description") val description: String,
    @ColumnInfo(name = "type") val type: String,
    @ColumnInfo(name = "location") val location: String,
)

fun PilaEntity.toDomain() = Pila(
    name = name,
    description = description,
    type = type,
    location = location,
)