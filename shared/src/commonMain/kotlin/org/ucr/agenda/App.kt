package org.ucr.agenda

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

/** Punto de entrada compartido. Las pantallas y la lógica se agregarán por ramas. */
@Composable
fun App() {
    MaterialTheme {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Text("Proyecto Kotlin Multiplatform")
        }
    }
}
