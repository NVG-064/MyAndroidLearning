package io.github.nvg064.myandroidlearning.app_component.intent.explicit.ui.view.activity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.intent.explicit.data.model.MahasiswaModel
import io.github.nvg064.myandroidlearning.databinding.ActivityFirstExplicitWithDataBinding
import java.util.Locale

class FirstExplicitWithDataActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var _binding: ActivityFirstExplicitWithDataBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityFirstExplicitWithDataBinding.inflate(layoutInflater)
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
                val nim = _binding.tfNim.editText?.text.toString()
                val semesterParse = _binding.tfSemester.editText?.text.toString().toIntOrNull() ?: 0
                val semester = if (semesterParse in 1..14) semesterParse else 0
                var isGraduate = false

                val selectedRbId = _binding.rgGraduate.checkedRadioButtonId

                if (selectedRbId != -1) {
                    val currentSelectedRbId: RadioButton = findViewById(selectedRbId)
                    val rbText = currentSelectedRbId.text.toString().lowercase(Locale.ROOT)
                    isGraduate = rbText == "yes"
                }

                val mahasiswaData = MahasiswaModel(name, nim, semester, isGraduate)

                val secondExplicitDataIntent = Intent(this@FirstExplicitWithDataActivity, SecondExplicitWithDataActivity::class.java)
                secondExplicitDataIntent.putExtra(SecondExplicitWithDataActivity.EXTRA_MAHASISWA, mahasiswaData)
                startActivity(secondExplicitDataIntent)
            }
        }
    }
}