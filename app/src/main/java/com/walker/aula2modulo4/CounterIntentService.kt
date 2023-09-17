package com.walker.aula2modulo4

import android.app.IntentService
import android.content.Intent
import android.util.Log

class CounterIntentService: IntentService("CounterIntentService") {

    private var stopCondition: Boolean = false

    private val TAG = "CounterIntentService"

    override fun onHandleIntent(intent: Intent?) {
        for (i in 1..5) {
            if (stopCondition) return
            Log.d(TAG, "Counter: $i")
            Thread.sleep(1000)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        stopCondition = true
    }
}