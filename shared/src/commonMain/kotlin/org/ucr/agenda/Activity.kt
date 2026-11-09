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

