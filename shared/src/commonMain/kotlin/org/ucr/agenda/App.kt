package org.ucr.agenda

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import kotlinx.serialization.Serializable

@Serializable
data object ListDestination

@Serializable
data object FormDestination

@Composable
fun App() {
    val store = remember { ActivityStore() }
    val navigation = rememberNavController()
    var notice by remember { mutableStateOf<String?>(null) }

    MaterialTheme(colorScheme = if (isSystemInDarkTheme()) darkColorScheme() else lightColorScheme()) {
        Surface(modifier = Modifier.fillMaxSize()) {
            NavHost(navController = navigation, startDestination = ListDestination) {
                composable<ListDestination> {
                    ActivityListScreen(
                        activities = store.activities,
                        notice = notice,
                        onNewActivity = {
                            notice = null
                            navigation.navigate(FormDestination)
                        },
                    )
                }
                composable<FormDestination> {
                    ActivityFormScreen(
                        onBack = { navigation.popBackStack() },
                        onSave = { draft ->
                            store.add(draft)
                            notice = "Actividad guardada correctamente."
                            navigation.popBackStack()
                        },
                    )
                }
            }
        }
    }
}
