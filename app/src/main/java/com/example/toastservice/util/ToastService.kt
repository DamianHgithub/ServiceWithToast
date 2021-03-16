package com.example.toastservice.util

import android.app.Notification
import android.app.Service
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.Looper
import android.widget.Toast
import androidx.core.app.NotificationCompat
import com.example.toastservice.R
import com.example.toastservice.di.DIManager

class ToastService: Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        Handler(Looper.myLooper()!!).postDelayed({
            Toast.makeText(applicationContext, "Test Message from service.", Toast.LENGTH_SHORT).show()
            stopSelf()
        }, 5000)

        val mNotification = NotificationCompat.Builder(this, DIManager.channelID)
            .setContentTitle("Toast Service")
            .setContentText("Service will turn off after a short time (1 minute)")
            .setSmallIcon(R.drawable.ic_android_white_24dp)
            .build()

        startForeground(1, mNotification)
        return START_NOT_STICKY
    }
    override fun onCreate() {
        super.onCreate()
    }
    override fun onDestroy() {
        super.onDestroy()
    }
    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}