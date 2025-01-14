package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.custom_broadcast.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view.ToastView

class CustomReceiver() : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "ACTION_BUTTON_CLICKED" && context != null) {
            val message = intent?.extras?.getString("data") ?: "No data received"
            ToastView.showToast(context, message)
        }
    }
}