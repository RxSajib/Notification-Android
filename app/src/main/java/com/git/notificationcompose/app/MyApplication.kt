package com.git.notificationcompose.app

import android.app.Application
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build

const val Default = "Default"
const val Default_Name = "Default_Name"

const val Silent_Notification_Id = "Silent_Notification_Id"
const val Silent_Notification_Name = "Silent_Notification_Name"

class MyApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            val channel = NotificationChannel(Default, Default_Name, NotificationManager.IMPORTANCE_DEFAULT)

            val silent_notification_channel = NotificationChannel(Silent_Notification_Id, Silent_Notification_Name, NotificationManager.IMPORTANCE_LOW)

            val notificationManager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            notificationManager.createNotificationChannels(listOf(channel, silent_notification_channel))
        }
    }
}