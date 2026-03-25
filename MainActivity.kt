
package com.hjenvios

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.*
import androidx.compose.runtime.*

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            App()
        }
    }
}

@Composable
fun App() {
    var clients by remember { mutableStateOf(listOf<String>()) }
    var text by remember { mutableStateOf("") }

    Column {
        Text("H&J ENVÍOS")

        TextField(value = text, onValueChange = { text = it })

        Button(onClick = {
            if (text.isNotEmpty()) {
                clients = clients + text
                text = ""
            }
        }) {
            Text("Agregar Cliente")
        }

        clients.forEach { client ->
            Text(client)
        }
    }
}
