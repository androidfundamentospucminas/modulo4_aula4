package com.walker.aula2modulo4

import android.content.Context
import android.util.Log
import androidx.work.Worker
import androidx.work.WorkerParameters

class CounterWorker(
    context: Context,
    params: WorkerParameters
): Worker(context, params) {
    private val TAG = "CounterWorker"
    private var stopCondition: Boolean = false

    override fun doWork(): Result {
        for (i in 1..5) {
            if (stopCondition) return Result.failure()

            Log.d(TAG, "Counter: $i")

            Thread.sleep(1000)
        }
        return Result.success()
    }

    override fun onStopped() {
        super.onStopped()
        stopCondition = true
    }
}