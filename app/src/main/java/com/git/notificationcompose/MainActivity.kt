package com.git.notificationcompose

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
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.git.notificationcompose.notification.createSilentNotification
import com.git.notificationcompose.notification.createSimpleNotification
import com.git.notificationcompose.ui.theme.NotificationComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NotificationComposeTheme {

                Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center){
                    Column {
                        Button(onClick = {
                            createSimpleNotification(this@MainActivity)
                        }) {
                            Text(
                                text = "Simple Notification"
                            )
                        }
                        Spacer(modifier = Modifier.height(10.dp))
                        Button(onClick = {
                            createSilentNotification(this@MainActivity)
                        }) {
                            Text(
                                text = "Silent Notification"
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    NotificationComposeTheme {
        Greeting("Android")
    }
}