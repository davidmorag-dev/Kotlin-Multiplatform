package org.ucr.agenda

data class ActivityItem(
    val id: Int,
    val title: String,
    val date: String,
    val description: String,
)

data class ActivityDraft(
    val title: String,
    val date: String,
    val description: String,
)

data class FormErrors(
    val title: String? = null,
    val date: String? = null,
    val description: String? = null,
) {
    val isValid: Boolean get() = title == null && date == null && description == null
}

fun validateActivity(draft: ActivityDraft): FormErrors {
    val titleError = when {
        draft.title.isBlank() -> "Escribe un título."
        draft.title.trim().length < 3 -> "Usa al menos tres caracteres."
        else -> null
    }
    val dateError = if (isValidIsoDate(draft.date.trim())) null else "Usa una fecha válida: AAAA-MM-DD."
    val descriptionError = when {
        draft.description.isBlank() -> "Escribe una descripción."
        draft.description.trim().length < 5 -> "Usa al menos cinco caracteres."
        else -> null
    }
    return FormErrors(titleError, dateError, descriptionError)
}

private fun isValidIsoDate(value: String): Boolean {
    val match = Regex("^(\\d{4})-(\\d{2})-(\\d{2})$").matchEntire(value) ?: return false
    val year = match.groupValues[1].toInt()
    val month = match.groupValues[2].toInt()
    val day = match.groupValues[3].toInt()
    if (year < 1 || month !in 1..12) return false
    val leapYear = year % 4 == 0 && (year % 100 != 0 || year % 400 == 0)
    val daysInMonth = when (month) {
        2 -> if (leapYear) 29 else 28
        4, 6, 9, 11 -> 30
        else -> 31
    }
    return day in 1..daysInMonth
}
