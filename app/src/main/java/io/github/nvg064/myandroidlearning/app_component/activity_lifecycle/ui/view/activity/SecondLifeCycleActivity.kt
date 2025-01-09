package io.github.nvg064.myandroidlearning.app_component.activity_lifecycle.ui.view.activity

import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.databinding.ActivitySecondLifeCycleBinding

class SecondLifeCycleActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivitySecondLifeCycleBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onCreate() invoked")
        enableEdgeToEdge()

        _binding = ActivitySecondLifeCycleBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnBackActivity.setOnClickListener(this)
    }

    override fun onStart() {
        super.onStart()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onStart() invoked")
    }

    override fun onRestart() {
        super.onRestart()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onRestart() invoked")
    }

    override fun onResume() {
        super.onResume()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onResume() invoked")
    }

    override fun onPause() {
        super.onPause()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onPause() invoked")
    }

    override fun onStop() {
        super.onStop()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onStop() invoked")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("SecondLifeCycleActivity", "SecondLifeCycleActivity onDestroy() invoked")
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_back_activity -> {
                finish()
            }
        }
    }
}