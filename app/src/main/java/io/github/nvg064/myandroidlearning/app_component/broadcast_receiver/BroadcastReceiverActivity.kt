package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.custom_broadcast.ui.view.activity.CustomBroadcastReceiverActivity
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view.activity.DynamicBroadcastReceiverActivity
import io.github.nvg064.myandroidlearning.databinding.ActivityBroadcastReceiverBinding

class BroadcastReceiverActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityBroadcastReceiverBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityBroadcastReceiverBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnDynamicBroadcastReceiver.setOnClickListener(this)
        _binding.btnCustomBroadcastReceiver.setOnClickListener(this)
        _binding.tvBroadcastReceiverDesc.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.tv_broadcast_receiver_desc -> {
                val url = "https://medium.com/@khush.panchal123/understanding-broadcast-receivers-in-android-044fbfaa1330"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            R.id.btn_dynamic_broadcast_receiver -> {
                val dynamicBroadcastReceiverIntent = Intent(this@BroadcastReceiverActivity, DynamicBroadcastReceiverActivity::class.java)
                startActivity(dynamicBroadcastReceiverIntent)
            }
            R.id.btn_custom_broadcast_receiver -> {
                val customBroadcastReceiverIntent = Intent(this@BroadcastReceiverActivity, CustomBroadcastReceiverActivity::class.java)
                startActivity(customBroadcastReceiverIntent)
            }
        }
    }
}