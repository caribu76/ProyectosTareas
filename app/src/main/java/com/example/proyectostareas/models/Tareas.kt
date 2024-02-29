package com.example.proyectostareas.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.ForeignKey

@Entity(tableName = "tareas",
    foreignKeys = [ForeignKey(
        entity = Proyecto::class,
        parentColumns = ["id"],
        childColumns = ["proyectoId"],
        onDelete = ForeignKey.CASCADE
    )]
)
data class Tarea(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val titulo: String,
    val descripcion: String,
    val estado: EstadoTarea = EstadoTarea.PENDIENTE, // Usando enumeración para el estado de la tarea
    val proyectoId: Int // Clave foránea referenciando a Proyecto
)

enum class EstadoTarea { PENDIENTE, EN_PROGRESO, COMPLETADA }
