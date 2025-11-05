package com.example.adhkar

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import kotlinx.serialization.Serializable
import kotlinx.serialization.json.Json
import java.io.BufferedReader

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                Surface(modifier = Modifier.fillMaxSize()) {
                    val context = LocalContext.current
                    var adhkar by remember { mutableStateOf<List<AdhkarItem>>(emptyList()) }
                    LaunchedEffect(Unit) {
                        adhkar = loadAdhkar(context)
                    }
                    AdhkarList(items = adhkar)
                }
            }
        }
    }

    private fun loadAdhkar(context: android.content.Context): List<AdhkarItem> {
        return try {
            val jsonString = context.assets.open("adhkar.json").bufferedReader().use(BufferedReader::readText)
            Json.decodeFromString(jsonString)
        } catch (e: Exception) {
            emptyList()
        }
    }
}

@Serializable
data class AdhkarItem(
    val title: String,
    val content: String
)

@Composable
fun AdhkarList(items: List<AdhkarItem>) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        items(items) { item ->
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 8.dp),
                elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
            ) {
                Column(modifier = Modifier.padding(16.dp)) {
                    Text(text = item.title, style = MaterialTheme.typography.titleMedium)
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(text = item.content, style = MaterialTheme.typography.bodyMedium)
                }
            }
        }
    }
}
