package org.ucr.agenda

import androidx.compose.runtime.mutableStateListOf

/** Datos locales observables por Compose durante la ejecución de la aplicación. */
class ActivityStore {
    private val entries = mutableStateListOf(
        ActivityItem(1, "Reunión del equipo", "2026-11-09", "Revisar las tareas de la investigación."),
        ActivityItem(2, "Ensayo de la demo", "2026-11-10", "Practicar el recorrido de la aplicación."),
    )

    val activities: List<ActivityItem> get() = entries
}
