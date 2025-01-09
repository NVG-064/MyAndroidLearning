package io.github.nvg064.myandroidlearning.app_component.intent.explicit.ui.view.activity

import android.os.Build
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.app_component.intent.explicit.data.model.MahasiswaModel
import io.github.nvg064.myandroidlearning.databinding.ActivitySecondExplicitWithDataBinding

class SecondExplicitWithDataActivity : AppCompatActivity() {
    private lateinit var _binding: ActivitySecondExplicitWithDataBinding

    companion object {
        const val EXTRA_MAHASISWA = "extra_mahasiswa"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivitySecondExplicitWithDataBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val mahasiswaData = if (Build.VERSION.SDK_INT >= 33) {
            intent.getParcelableExtra(EXTRA_MAHASISWA, MahasiswaModel::class.java)
        } else {
            @Suppress("DEPRECATION")
            intent.getParcelableExtra(EXTRA_MAHASISWA)
        }

        if (mahasiswaData != null) {
            Log.i("INFO", mahasiswaData.name.toString())
            _binding.tvName.text = "Name: ${mahasiswaData.name}"
            _binding.tvNim.text = "NIM: ${mahasiswaData.nim}"
            _binding.tvSemester.text = "Semester: ${mahasiswaData.semester}"
            _binding.tvGraduate.text = "Graduated? ${mahasiswaData.isGraduate}"
        }
    }
}