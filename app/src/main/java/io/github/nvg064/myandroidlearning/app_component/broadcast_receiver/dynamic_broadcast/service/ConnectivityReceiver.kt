package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.service

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view.ToastView

class ConnectivityReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context?, intent: Intent?) {
        if (intent?.action == "android.net.conn.CONNECTIVITY_CHANGE" && context != null) {
            val message = "Network changed"
            ToastView.showToast(context, message)
        }
    }

}