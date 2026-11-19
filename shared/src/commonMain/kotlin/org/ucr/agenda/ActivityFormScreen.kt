package org.ucr.agenda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActivityFormScreen(onBack: () -> Unit, onSave: (ActivityDraft) -> Unit) {
    var title by remember { mutableStateOf("") }
    var date by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var errors by remember { mutableStateOf(FormErrors()) }

    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.widthIn(max = 680.dp).fillMaxWidth()
                .verticalScroll(rememberScrollState()).padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text("Nueva actividad", style = MaterialTheme.typography.headlineMedium)
            Text("Completa los tres campos para guardar.", style = MaterialTheme.typography.bodyMedium)

            OutlinedTextField(
                value = title,
                onValueChange = { title = it; errors = errors.copy(title = null) },
                label = { Text("Título") },
                isError = errors.title != null,
                supportingText = { errors.title?.let { Text(it) } },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                value = date,
                onValueChange = { date = it; errors = errors.copy(date = null) },
                label = { Text("Fecha") },
                placeholder = { Text("AAAA-MM-DD") },
                isError = errors.date != null,
                supportingText = { errors.date?.let { Text(it) } },
                singleLine = true,
                modifier = Modifier.fillMaxWidth(),
            )
            OutlinedTextField(
                value = description,
                onValueChange = { description = it; errors = errors.copy(description = null) },
                label = { Text("Descripción") },
                isError = errors.description != null,
                supportingText = { errors.description?.let { Text(it) } },
                minLines = 3,
                modifier = Modifier.fillMaxWidth(),
            )
            Row(horizontalArrangement = Arrangement.spacedBy(12.dp)) {
                OutlinedButton(onClick = onBack) { Text("Volver") }
                Button(onClick = {
                    val draft = ActivityDraft(title, date, description)
                    errors = validateActivity(draft)
                    if (errors.isValid) onSave(draft)
                }) { Text("Guardar") }
            }
        }
    }
}
