package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.features.login.LoginContent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class PilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {
     var _state = mutableStateOf(emptyList<Pila>())

    init {
        viewModelScope.launch {
            withContext(Dispatchers.IO) {
                _state.value = repository.getPilas()
                Log.d("PilasViewModel", "PilasViewModel: $_state")
            }
        }
    }

}



