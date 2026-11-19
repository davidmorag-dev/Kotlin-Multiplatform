package org.ucr.agenda

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.widthIn
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun ActivityListScreen(
    activities: List<ActivityItem>,
    notice: String?,
    onNewActivity: () -> Unit,
) {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.TopCenter) {
        Column(
            modifier = Modifier.widthIn(max = 680.dp).fillMaxWidth().padding(20.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp),
        ) {
            Text("Agenda de actividades", style = MaterialTheme.typography.headlineMedium)
            Text("Organiza tus pendientes en una lista sencilla.", style = MaterialTheme.typography.bodyMedium)
            Button(onClick = onNewActivity) { Text("Nueva actividad") }
            if (notice != null) {
                Surface(color = MaterialTheme.colorScheme.primaryContainer, shape = MaterialTheme.shapes.medium) {
                    Text(notice, modifier = Modifier.padding(12.dp))
                }
            }
            Text("Actividades (${activities.size})", style = MaterialTheme.typography.titleLarge)
            LazyColumn(
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp),
            ) {
                items(activities, key = { it.id }) { item -> ActivityCard(item) }
            }
        }
    }
}

@Composable
private fun ActivityCard(item: ActivityItem) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(modifier = Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(4.dp)) {
            Text(item.title, style = MaterialTheme.typography.titleMedium)
            Text(item.date, style = MaterialTheme.typography.labelMedium, color = MaterialTheme.colorScheme.primary)
            Text(item.description, style = MaterialTheme.typography.bodyMedium)
        }
    }
}
