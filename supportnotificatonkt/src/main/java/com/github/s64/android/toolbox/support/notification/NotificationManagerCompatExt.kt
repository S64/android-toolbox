package com.github.s64.android.toolbox.support.notification

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import android.support.annotation.RequiresApi
import android.support.v4.app.NotificationManagerCompat

fun NotificationManagerCompat.getNotificationManager(context: Context): NotificationManager {
    return context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
}

@RequiresApi(Build.VERSION_CODES.O)
fun NotificationManagerCompat.createNotificationChannel(context: Context, channel: NotificationChannel) {
    getNotificationManager(context).createNotificationChannel(channel)
}

fun NotificationManagerCompat.createNotificationChannelOrNothing(context: Context, channel: NotificationChannel): Boolean {
    return if (isChannelSupported()) {
        createNotificationChannel(context, channel)
        true
    } else {
        false
    }
}

fun NotificationManagerCompat.isChannelSupported(): Boolean {
    return Build.VERSION.SDK_INT >= Build.VERSION_CODES.O
}
