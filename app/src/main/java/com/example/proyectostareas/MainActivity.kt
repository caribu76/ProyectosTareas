package com.example.proyectostareas

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.proyectostareas.vistas.ProyectosScreen
import com.example.proyectostareas.ui.theme.ProyectosTareasTheme
import com.example.proyectostareas.vistas.TareasScreen
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.ButtonDefaults
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource



class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ProyectosTareasTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppNavigation()
                }
            }
        }
    }
}

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "home") {
        composable("home") { ProyectosTareasScreen(navController) }
        composable("proyectos") { ProyectosScreen(navController) } // Pasa navController aquí
        composable("tareas") { TareasScreen(navController) } // Y aquí si es necesario
    }
}

@Composable
fun ProyectosTareasScreen(navController: NavController) {
    Box(modifier = Modifier.fillMaxSize()) {
        // Fondo
        Image(
            painter = painterResource(id = R.drawable.fondo),
            contentDescription = "Fondo",
            modifier = Modifier.matchParentSize(),
            contentScale = ContentScale.Crop // Asegura que la imagen cubra toda la pantalla
        )

        // Usando un gradiente para mejorar la legibilidad del texto sobre la imagen de fondo
        Box(
            modifier = Modifier
                .matchParentSize()
                .background(
                    Brush.verticalGradient(
                    colors = listOf(Color.Transparent, MaterialTheme.colorScheme.surface.copy(alpha = 0.5f)),
                    startY = 300f // Ajusta según sea necesario para tu diseño
                ))
        )

        Column(
            modifier = Modifier

                .padding(horizontal = 32.dp), // Ajusta el padding horizontal para centrar el contenido
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Proyectos&Tareas",
                style = MaterialTheme.typography.headlineMedium.copy(color = MaterialTheme.colorScheme.onSurface),
                modifier = Modifier.padding(bottom = 62.dp) // Ajusta el espacio antes de los botones

            )
            Button(
                onClick = { navController.navigate("proyectos") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 16.dp), // Espacio entre botones
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Proyectos", color = MaterialTheme.colorScheme.onPrimary)
            }
            Button(
                onClick = { navController.navigate("tareas") },
                modifier = Modifier.fillMaxWidth(),
                colors = ButtonDefaults.buttonColors(containerColor = MaterialTheme.colorScheme.primary)
            ) {
                Text("Tareas", color = MaterialTheme.colorScheme.onPrimary)
            }
        }
    }
}


@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ProyectosTareasTheme {

        val navController = rememberNavController()
        ProyectosTareasScreen(navController)
    }
}