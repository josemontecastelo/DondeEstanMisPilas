package com.josealfonsomora.dondeestanmispilas.features.pilas

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject


@HiltViewModel
class PilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {
    private var _state: List<Pila> = emptyList()
    val state
        get() = _state

    init {
        _state = repository.descargaPilas()
    }

    fun guardarPila(pila: Pila) {
        repository.guardarPila(pila)
    }
}


data class Pila(
    val name: String,
    val description: String,
    val type: String,
    val location: String,
)

