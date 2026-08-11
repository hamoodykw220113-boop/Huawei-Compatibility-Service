package com.huawei.compatibility

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MainService : Service() {
    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        ApiLayer.start()
        SpoofingLayer.start()
        MicroGIntegration.start()
        PerformanceMods.start()
        Updater.checkForUpdates()
        return START_STICKY
    }

    override fun onBind(intent: Intent?): IBinder? {
        return null
    }
}
