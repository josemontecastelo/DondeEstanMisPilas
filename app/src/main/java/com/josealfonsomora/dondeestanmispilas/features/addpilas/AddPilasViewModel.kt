package com.josealfonsomora.dondeestanmispilas.features.addpilas

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.features.pilas.PilasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddPilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {

    fun guardarPila(pila: Pila) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.guardarPila(pila)
            }
        }
    }
}