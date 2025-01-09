package io.github.nvg064.myandroidlearning.app_component.intent

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.intent.explicit.ui.view.activity.FirstExplicitWithDataActivity
import io.github.nvg064.myandroidlearning.app_component.intent.implicit.ui.view.activity.ImplicitFirstActivity
import io.github.nvg064.myandroidlearning.databinding.ActivityIntentBinding

class IntentActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityIntentBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityIntentBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnExplicitIntentWithData.setOnClickListener(this)
        _binding.btnImplicitIntent.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_explicit_intent_with_data -> {
                val firstExplicitWithDataIntent = Intent(this@IntentActivity, FirstExplicitWithDataActivity::class.java)
                startActivity(firstExplicitWithDataIntent)
            }
            R.id.btn_implicit_intent -> {
                val implicitIntentIntent = Intent(this@IntentActivity, ImplicitFirstActivity::class.java)
                startActivity(implicitIntentIntent)
            }
        }
    }
}