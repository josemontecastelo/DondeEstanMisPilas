package com.josealfonsomora.dondeestanmispilas.features.addpilas

import androidx.lifecycle.ViewModel
import com.josealfonsomora.dondeestanmispilas.features.pilas.Pila
import com.josealfonsomora.dondeestanmispilas.features.pilas.PilasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class AddPilasViewModel @Inject constructor(
    private val repository: PilasRepository
): ViewModel(){

    fun guardarPila(pila: Pila) {
        repository.guardarPila(pila)
    }
}