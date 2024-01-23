package com.josealfonsomora.dondeestanmispilas.features.pilas

import javax.inject.Inject

class PilasRepository @Inject constructor(
//    private val api: PilasAPI,
//    private val sharedPreferences: SharedPreferences,
//    private val db: PilasDatabase
) {
    var pilas = mutableListOf(
        Pila(
            name = "Pila 1",
            description = "Recargable Duracel AA",
            location = "Osito de peluche",
            type = "AA",
        ),
        Pila(
            name = "Pila 2",
            description = "Recargable Duracel AAA",
            location = "Mando de la tele",
            type = "AAA",
        ),
    )

    fun descargaPilas() = pilas


    fun guardarPila(pila: Pila) {
        pilas.add(pila)
    }
}
