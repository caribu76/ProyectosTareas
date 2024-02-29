package com.example.proyectostareas.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.proyectostareas.repository.TareasRepository
import com.example.proyectostareas.vistas.Tarea
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TareasViewModel @Inject constructor(private val repository: TareasRepository) : ViewModel() {

    val todasLasTareas: Flow<List<com.example.proyectostareas.models.Tarea>> = repository.todasLasTareas

    // Ejemplo para insertar una tarea
    fun insertar(tarea: Tarea) = viewModelScope.launch {
        repository.insertar(tarea)
    }


}
