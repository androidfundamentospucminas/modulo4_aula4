package com.walker.aula2modulo4

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import androidx.work.OneTimeWorkRequestBuilder
import androidx.work.WorkManager

class MainActivity : AppCompatActivity() {

    private lateinit var startButton: Button
    private lateinit var stopButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        startButton = findViewById(R.id.startButton)
        stopButton = findViewById(R.id.stopButton)

        // val counterIntentService = Intent(this, CounterIntentService::class.java)

        startButton.setOnClickListener {
            // startService(counterIntentService)
            val worker = OneTimeWorkRequestBuilder<CounterWorker>().build()
            WorkManager.getInstance(applicationContext).enqueue(worker)
        }

        stopButton.setOnClickListener {
            // stopService(counterIntentService)
            WorkManager.getInstance(applicationContext).cancelAllWork()
        }
    }
}