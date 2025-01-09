package io.github.nvg064.myandroidlearning

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.app_component.AppComponentActivity
import io.github.nvg064.myandroidlearning.databinding.ActivityMyAndroidLearningBinding

class MyAndroidLearningActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityMyAndroidLearningBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityMyAndroidLearningBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnAppComponent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_app_component -> {
                val appComponentIntent = Intent(this@MyAndroidLearningActivity, AppComponentActivity::class.java)
                startActivity(appComponentIntent)
            }
        }
    }
}