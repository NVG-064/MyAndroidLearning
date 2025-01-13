package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view.activity

import android.content.IntentFilter
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.service.ConnectivityReceiver
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.service.SmsReceiver
import io.github.nvg064.myandroidlearning.databinding.ActivityDynamicBroadcastReceiverBinding

class DynamicBroadcastReceiverActivity : AppCompatActivity() {
    private lateinit var _binding : ActivityDynamicBroadcastReceiverBinding
    private val _smsReceiver = SmsReceiver()
    private val _connectivityReceiver = ConnectivityReceiver()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityDynamicBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        registerReceiver(_smsReceiver, IntentFilter("android.provider.Telephony.SMS_RECEIVED"))
        registerReceiver(_connectivityReceiver, IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"))
    }

    override fun onDestroy() {
        super.onDestroy()

        unregisterReceiver(_smsReceiver)
        unregisterReceiver(_connectivityReceiver)
    }
}