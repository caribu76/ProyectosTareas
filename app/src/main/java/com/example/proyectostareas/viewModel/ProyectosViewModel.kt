package com.example.proyectostareas.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.State
import com.example.proyectostareas.models.Proyecto
import com.example.proyectostareas.repository.ProyectosRepository
import kotlinx.coroutines.launch
import javax.inject.Inject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlin.text.Typography.dagger

@HiltViewModel
class ProyectosViewModel @Inject constructor(private val proyectosRepository: ProyectosRepository<Any?>) : ViewModel() {
    private val _proyectos = mutableStateOf<List<Proyecto>>(emptyList())
    val proyectos: State<List<Proyecto>> = _proyectos
    private val _estado = mutableStateOf<EstadoCarga>(EstadoCarga.Idle)
    val estado: State<EstadoCarga> = _estado

    init {
        cargarProyectos()
    }

    private fun cargarProyectos() {
        viewModelScope.launch {
            _estado.value = EstadoCarga.Cargando
            try {
                _proyectos.value = proyectosRepository.getTodosLosProyectos() as List<Proyecto>
                _estado.value = EstadoCarga.Completado
            } catch (e: Exception) {
                _estado.value = EstadoCarga.Error
            }
        }
    }

    // Métodos para agregar y eliminar proyectos...

    enum class EstadoCarga { Idle, Cargando, Error, Completado }
}
