package com.example.proyectostareas.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.proyectostareas.vistas.Proyecto
import kotlinx.coroutines.flow.Flow

@Dao
interface ProyectosDao {
    @Query("SELECT * FROM proyectos")
    fun getAllProyectos(): Flow<List<Proyecto>>

    @Insert
    suspend fun insertProyecto(proyecto: Proyecto)

    @Query("DELETE FROM proyectos")
    suspend fun deleteAllProyectos()

    @Update
    suspend fun updateProyecto(proyecto: Proyecto)

    @Delete
    suspend fun deleteProyecto(proyecto: Proyecto)

    @Query("DELETE FROM proyectos WHERE id = :proyectoId")
    suspend fun deleteProyectoById(proyectoId: Int)


}
