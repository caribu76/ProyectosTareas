@file:Suppress("COMPATIBILITY_WARNING")


// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.0" apply false
    // Añade cualquier otro plugin a nivel de proyecto aquí
}

val ext = ext {
    // Definir las versiones de las herramientas y bibliotecas como variables para facilitar la gestión y actualización
    // Asegúrate de que la versión de Kotlin esté actualizada
    // Agregar más variables de versión según sea necesario
}
buildscript {

    repositories {
        google()
        mavenCentral()
        // Añadir otros repositorios si es necesario
    }

    dependencies {
        classpath ("com.google.dagger:hilt-android-gradle-plugin:2.40.1")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.1")
        // Asegúrate de incluir también otras dependencias de classpath necesarias para tu proyecto
    }
}

