package com.example.proyectostareas.models

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.time.LocalDate

// Enumeraciones para estatus y prioridad
enum class Estatus { ACTIVO, COMPLETADO, PENDIENTE }
enum class Prioridad { ALTA, MEDIA, BAJA }

@Entity(tableName = "proyectos")
data class Proyecto(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val nombre: String,
    val descripcion: String,
    val fechaInicio: LocalDate, // Cambiado de String a LocalDate
    val fechaFin: LocalDate, // Cambiado de String a LocalDate
    val estatus: Estatus, // Usando enumeración
    val prioridad: Prioridad, // Usando enumeración
    val responsable: String
)
