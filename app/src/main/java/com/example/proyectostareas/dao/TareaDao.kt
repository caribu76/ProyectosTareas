package com.example.proyectostareas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyectostareas.vistas.Tarea
import kotlinx.coroutines.flow.Flow

@Dao
interface TareaDao {
    @Query("SELECT * FROM tareas")
    fun getAllTareas(): Flow<List<Tarea>>

    @Insert
    suspend fun insertTarea(tarea: Tarea)

    @Query("DELETE FROM tareas")
    suspend fun deleteAllTareas()

    @Update
    suspend fun updateTarea(tarea: Tarea)

    @Delete
    suspend fun deleteTarea(tarea: Tarea)

    @Query("DELETE FROM tareas WHERE id = :tareaId")
    suspend fun deleteTareaById(tareaId: Int)

}

annotation class Dao
