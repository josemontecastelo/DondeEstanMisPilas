package com.josealfonsomora.dondeestanmispilas.ui.addpilas

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.data.repositories.PilasRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AddPilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {

    private val _state = MutableStateFlow<Int>(0)
    val state = _state

    init {
        viewModelScope.launch {
            Log.d("AddPilasViewModel", "init")
            repository.getPilasFromDataStore().collect {
                _state.value = it
                Log.d("AddPilasViewModel", "pilas from datastore: $it")
            }
        }
    }
    fun guardarPila(pila: Pila) {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                repository.guardarPila(pila)
            }
        }
    }
}