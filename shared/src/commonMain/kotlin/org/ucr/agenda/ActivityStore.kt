package org.ucr.agenda

import androidx.compose.runtime.mutableStateListOf

/** Datos locales observables por Compose durante la ejecución de la aplicación. */
class ActivityStore {
    private val entries = mutableStateListOf(
        ActivityItem(1, "Reunión del equipo", "2026-11-09", "Revisar las tareas de la investigación."),
        ActivityItem(2, "Ensayo de la demo", "2026-11-10", "Practicar el recorrido de la aplicación."),
    )
<<<<<<< HEAD

    val activities: List<ActivityItem> get() = entries
=======
    private var nextId = 3

    val activities: List<ActivityItem> get() = entries

    fun add(draft: ActivityDraft): ActivityItem {
        require(validateActivity(draft).isValid) { "La actividad contiene datos inválidos." }
        val item = ActivityItem(
            id = nextId++,
            title = draft.title.trim(),
            date = draft.date.trim(),
            description = draft.description.trim(),
        )
        entries.add(0, item)
        return item
    }
>>>>>>> 26657a6d2b22eec00a8aa31c78c08464c9433df8
}
