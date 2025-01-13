package io.github.nvg064.myandroidlearning.app_component.broadcast_receiver.dynamic_broadcast.ui.view

import android.content.Context
import android.widget.Toast

class ToastView {
    companion object {
        fun showToast(context: Context, message: String) {
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        }
    }
}