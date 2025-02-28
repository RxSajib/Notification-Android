package com.git.notificationcompose.notification

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.git.notificationcompose.R
import com.git.notificationcompose.app.Default


fun createSimpleNotification(context: Context){
    val notification = NotificationCompat.Builder(context, Default)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("Title")
        .setContentText("This is a simple notification")
        .build()

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
        if(ContextCompat.checkSelfPermission(context, android.Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED){
            NotificationManagerCompat.from(context).notify(1, notification)
        }
    }else {
        NotificationManagerCompat.from(context).notify(1, notification)
    }
}