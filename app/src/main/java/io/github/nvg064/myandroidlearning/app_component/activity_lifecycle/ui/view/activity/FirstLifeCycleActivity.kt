package io.github.nvg064.myandroidlearning.app_component.activity_lifecycle.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.databinding.ActivityFirstLifeCycleBinding

class FirstLifeCycleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityFirstLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onCreate() invoked")
        enableEdgeToEdge()

        _binding = ActivityFirstLifeCycleBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnNextActivity.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onStart() invoked")
    }

    override fun onResume() {
        super.onResume()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onResume() invoked")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onRestart() invoked")
    }

    override fun onPause() {
        super.onPause()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onPause() invoked")
    }

    override fun onStop() {
        super.onStop()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onStop() invoked")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("FirstLifeCycleActivity", "FirstLifeCycleActivity onDestroy() invoked")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_next_activity -> {
                val nextActivityIntent = Intent(this@FirstLifeCycleActivity, SecondLifeCycleActivity::class.java)
                startActivity(nextActivityIntent)
            }
        }
    }
}