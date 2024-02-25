package com.josealfonsomora.dondeestanmispilas.features.pilas

import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.PilaEntity
import com.josealfonsomora.dondeestanmispilas.bd.pilas_db.toDomain
import com.josealfonsomora.dondeestanmispilas.domain.Pila
import com.josealfonsomora.dondeestanmispilas.features.login.LoginContent
import com.josealfonsomora.dondeestanmispilas.features.pilas.PilasState.Success
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineStart
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.async
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject


@HiltViewModel
class PilasViewModel @Inject constructor(
    private val repository: PilasRepository
) : ViewModel() {

    val channel = Channel<String>()

    private var _state: MutableStateFlow<PilasState> = MutableStateFlow(PilasState.Loading)
    val state:StateFlow<PilasState> = _state

    init {
       viewModelScope.launch {
//            channel.send("Te has quedado sin internet")
//            channel.send("Ya tienes internet")
//            repository.getCatsFact()
        }
        viewModelScope.launch {
//            delay(2000)
//            _state.value = Success(
//                pilas = listOf(
//                    Pila("Pila 1", "Esta es la pila 1", "AAA", "Mando TV"),
//                    Pila("Pila 2", "Esta es la pila 2", "AAA", "Mando TV"),
//                    Pila("Pila 3", "Esta es la pila 3", "AAA", "Mando TV"),
//                )
//            )
        }

        viewModelScope.launch {
            simpleMapped().collect {
                _state.value = Success(pilas = mutableListOf(it))
            }
        }
    }

    fun onCameraPermissionGranted(){
        viewModelScope.launch {
            channel.send("openCamera")
        }
    }

    fun simple(): Flow<Int> = flow { // flow builder
        Log.d("PilasViewModel", "simple: start")
        for(i in 0..4){
            delay(2000)
            emit(i)
        }
    }

    fun simpleMapped() = simple().filter {
        it % 2 == 0
    }.map {
        Pila("Pila $it", "Esta es la pila $it", "AAA", "Mando TV")
    }

    fun getPilasDB(): Flow<PilaEntity> = flow {
        PilaEntity("Pila 1", "Esta es la pila 1", "AAA", "Mando TV")
    }

    fun getPila():Flow<Pila> = getPilasDB().map{
        it.toDomain()
    }
}

sealed interface PilasState {
    object Loading: PilasState
    data class Success(val pilas: List<Pila>): PilasState
}


