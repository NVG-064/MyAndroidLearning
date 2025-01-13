package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view.ToastView

class SmsReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.provider.Telephony.SMS_RECEIVED" && context != null) {
            val message = "SMS received"
            ToastView.showToast(context, message)
        }
    }
}