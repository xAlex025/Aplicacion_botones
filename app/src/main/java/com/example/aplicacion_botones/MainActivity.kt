package com.example.aplicacion_botones

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.aplicacion_botones.ui.theme.Aplicacion_botonesTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AlertDialogScreen()
        }
    }
}


@Composable
fun AlertDialogScreen() {
    var showDialog by remember { mutableStateOf(false) }
    var dialogType by remember { mutableStateOf(0) }
    var message by remember { mutableStateOf("") }

    Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                dialogType = 1; showDialog = true
            }) { Text("Confirmación de Acción") }
            Button(onClick = { dialogType = 2; showDialog = true }) { Text("Eliminar Elemento") }
            Button(onClick = { dialogType = 3; showDialog = true }) { Text("Aviso Importante") }
            Button(onClick = {
                dialogType = 4; showDialog = true
            }) { Text("Requiere Autenticación") }
            Button(onClick = { dialogType = 5; showDialog = true }) { Text("Error Crítico") }

            Spacer(Modifier.height(20.dp))
            Text(text = message, style = MaterialTheme.typography.headlineMedium)

            if (showDialog) {
                when (dialogType) {
                    1 -> AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Confirmación de Acción") },
                        text = { Text("¿Estás seguro de que deseas continuar con esta acción?") },
                        confirmButton = {
                            TextButton(onClick = {
                                message = "Acción Confirmada"
                                showDialog = false
                            }) {
                                Text("Sí")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("No")
                            }
                        }
                    )

                    2 -> AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Eliminar Elemento") },
                        text = { Text("Esta acción es irreversible. ¿Deseas eliminar este elemento?") },
                        confirmButton = {
                            TextButton(onClick = {
                                message = "Elemento Eliminado Exitosamente"
                                showDialog = false
                            }) {
                                Text("Eliminar")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Cancelar")
                            }
                        }
                    )

                    3 -> AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Aviso Importante") },
                        text = { Text("Recuerda que los cambios realizados no se pueden deshacer.") },
                        confirmButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Entendido")
                            }
                        }
                    )

                    4 -> AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Requiere Autenticación") },
                        text = { Text("Para continuar, necesitas autenticarte de nuevo.") },
                        confirmButton = {
                            TextButton(onClick = {
                                message = "Usuario Autenticado"
                                showDialog = false
                            }) {
                                Text("Autenticar")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Cancelar")
                            }
                        }
                    )

                    5 -> AlertDialog(
                        onDismissRequest = { showDialog = false },
                        title = { Text("Error Crítico") },
                        text = { Text("Se ha producido un error crítico. ¿Deseas intentar nuevamente?") },
                        confirmButton = {
                            TextButton(onClick = {
                                message = "Intento de Reintento"
                                showDialog = false
                            }) {
                                Text("Reintentar")
                            }
                        },
                        dismissButton = {
                            TextButton(onClick = { showDialog = false }) {
                                Text("Cancelar")
                            }
                        }
                    )
                }
            }
        }
    }
}
