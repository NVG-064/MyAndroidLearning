package io.github.nvg064.myandroidlearning.app_component.intent.implicit.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.databinding.ActivityImplicitSecondBinding

class ImplicitSecondActivity : AppCompatActivity(), View.OnClickListener {
    companion object {
        const val EXTRA_NAME = "extra_name"
    }

    private lateinit var _binding: ActivityImplicitSecondBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityImplicitSecondBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnSubmitData.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_submit_data -> {
                val name = _binding.tfName.editText?.text.toString()

                val resultIntent = Intent()
                resultIntent.putExtra(EXTRA_NAME, name)
                setResult(RESULT_OK, resultIntent)
                finish()
            }
        }
    }
}