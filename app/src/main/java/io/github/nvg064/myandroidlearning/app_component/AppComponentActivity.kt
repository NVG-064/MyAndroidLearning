package io.github.nvg064.myandroidlearning.app_component

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.activity_lifecycle.ui.view.activity.FirstLifeCycleActivity
import io.github.nvg064.myandroidlearning.app_component.intent.IntentActivity
import io.github.nvg064.myandroidlearning.databinding.ActivityAppComponentBinding

class AppComponentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityAppComponentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityAppComponentBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnActivityLifecycle.setOnClickListener(this)
        _binding.btnIntent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_activity_lifecycle -> {
                val activityLifecycleIntent = Intent(this@AppComponentActivity, FirstLifeCycleActivity::class.java)
                startActivity(activityLifecycleIntent)
            }
            R.id.btn_intent -> {
                val intentIntent = Intent(this@AppComponentActivity, IntentActivity::class.java)
                startActivity(intentIntent)
            }
        }
    }
}