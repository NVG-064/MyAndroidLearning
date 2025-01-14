package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.custom_broadcast.ui.view.activity

import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.custom_broadcast.service.CustomReceiver
import io.github.nvg064.myandroidlearning.databinding.ActivityCustomBroadcastReceiverBinding

class CustomBroadcastReceiverActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityCustomBroadcastReceiverBinding
    private val _customReceiver = CustomReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityCustomBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        registerReceiver(_customReceiver, IntentFilter("ACTION_BUTTON_CLICKED"), RECEIVER_NOT_EXPORTED)
    }

    override fun onStart() {
        super.onStart()

        sendCustomIntent(applicationContext.packageName)
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(_customReceiver)
    }

    fun sendCustomIntent(packageName: String) {
        val intent = Intent("ACTION_BUTTON_CLICKED")
        intent.putExtra("data", "Action button clicked")
        intent.setPackage(packageName)
        sendBroadcast(intent)
    }
}