package com.git.notificationcompose.notification

import android.Manifest
import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import androidx.core.content.ContextCompat
import com.git.notificationcompose.R
import com.git.notificationcompose.app.Silent_Notification_Id

fun createSilentNotification(context: Context){
    val notification = NotificationCompat.Builder(context, Silent_Notification_Id)
        .setSmallIcon(R.drawable.ic_launcher_background)
        .setContentTitle("Silent")
        .setContentText("This is a notification")
        .build()

    if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU){
        if(ContextCompat.checkSelfPermission(context, Manifest.permission.POST_NOTIFICATIONS) == PackageManager.PERMISSION_GRANTED){
            NotificationManagerCompat.from(context).notify(2, notification)
        }
    }else {
        NotificationManagerCompat.from(context).notify(2, notification)
    }
}