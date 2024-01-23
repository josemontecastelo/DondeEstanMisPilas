package com.josealfonsomora.dondeestanmispilas.domain

import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.PilaEntity

data class Pila(
    val name: String,
    val description: String,
    val type: String,
    val location: String,
)

fun Pila.toEntity() = PilaEntity(
    name = name,
    description = description,
    type = type,
    location = location,
)