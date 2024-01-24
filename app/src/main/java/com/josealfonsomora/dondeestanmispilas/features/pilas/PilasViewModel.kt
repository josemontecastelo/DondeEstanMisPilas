package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.features.login.LoginContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class PilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {

    private var _state = MutableStateFlow(emptyList<Pila>())
    val state:StateFlow<List<Pila>> = _state

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = repository.getPilas()
            }
        }
    }
}



