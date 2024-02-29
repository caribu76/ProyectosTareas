package com.example.proyectostareas.repository


import com.example.proyectostareas.models.EstadoTarea
import com.example.proyectostareas.models.Tarea
import kotlinx.coroutines.flow.Flow

class TareasRepository(private val tareasDao: TareasDao) {

    // Obtener todas las tareas
    val todasLasTareas: Flow<List<Tarea>> = tareasDao.getAllTareas()

    // Insertar una tarea
    suspend fun insertar(tarea: com.example.proyectostareas.vistas.Tarea) {
        tareasDao.insertTarea(tarea)
    }

    // Actualizar una tarea
    suspend fun actualizar(tarea: Tarea) {
        tareasDao.updateTarea(tarea)
    }

    // Eliminar una tarea
    suspend fun eliminar(tarea: Tarea) {
        tareasDao.deleteTarea(tarea)
    }

    // Eliminar todas las tareas
    suspend fun eliminarTodas() {
        tareasDao.deleteAllTareas()
    }

    // Obtener tareas por estado, ejemplo: completadas, pendientes, etc.
    // Asumiendo que tienes un método en tu DAO para esto.
    fun obtenerTareasPorEstado(estado: EstadoTarea): Flow<List<Tarea>> {
        return tareasDao.getTareasPorEstado(estado)
    }
}

class TareasDao {
    fun getAllTareas(): Flow<List<Tarea>> {
        TODO("Not yet implemented")
    }

    fun insertTarea(tarea: com.example.proyectostareas.vistas.Tarea) {
        TODO("Not yet implemented")
    }

    fun updateTarea(tarea: Tarea) {
        TODO("Not yet implemented")
    }

    fun deleteTarea(tarea: Tarea) {
        TODO("Not yet implemented")
    }

    fun deleteAllTareas() {
            TODO("Not yet implemented")
    }

    fun getTareasPorEstado(estado: EstadoTarea): Flow<List<Tarea>> {
        TODO("Not yet implemented")
    }

}
