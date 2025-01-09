package io.github.nvg064.myandroidlearning.app_component.intent.implicit.ui.view.activity

import android.Manifest
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.net.Uri
import android.os.Bundle
import android.provider.MediaStore
import android.view.View
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import io.github.nvg064.myandroidlearning.R
import io.github.nvg064.myandroidlearning.databinding.ActivityImplicitFirstBinding

class ImplicitFirstActivity : AppCompatActivity(), View.OnClickListener {
    private val _permissionCameraLauncher = registerForActivityResult(ActivityResultContracts.RequestPermission()) {
        isGranted: Boolean ->
        run {
            if (isGranted) {
                _openCamera()
            } else {
                Toast.makeText(this, "Please allow Camera permission", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private val _cameraResultLauncher = registerForActivityResult(ActivityResultContracts.TakePicturePreview()) {
        bitmap: Bitmap? ->
        run {
            if (bitmap != null) {
                _binding.ivCameraResult.setImageBitmap(bitmap)
            }
        }
    }

    private val _resultLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()) {
        result ->
        run {
            if (result.resultCode == RESULT_OK && result.data != null) {
                val data = result.data?.getStringExtra(ImplicitSecondActivity.EXTRA_NAME)
                _binding.tvIntentResult.text = data
            }
        }
    }

    private lateinit var _binding: ActivityImplicitFirstBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        enableEdgeToEdge()

        _binding = ActivityImplicitFirstBinding.inflate(layoutInflater)
        setContentView(_binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        _binding.btnIntentActionDial.setOnClickListener(this)
        _binding.btnIntentActionOpenLink.setOnClickListener(this)
        _binding.btnIntentWithData.setOnClickListener(this)
        _binding.btnIntentWithDataCamera.setOnClickListener(this)
    }

    private fun _openCamera() {
        _cameraResultLauncher.launch(null)
    }

    private fun _checkCameraPermission() {
        when {
            ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA) == PackageManager.PERMISSION_GRANTED -> {
                _openCamera()
            }
            ActivityCompat.shouldShowRequestPermissionRationale(this@ImplicitFirstActivity, Manifest.permission.CAMERA) -> {
                // TODO("Show widgets to explain why need this permission")
            }
            else -> {
                _permissionCameraLauncher.launch(Manifest.permission.CAMERA)
            }
        }
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn_intent_action_dial -> {
                val phoneNumber = "0895365260871"
                val dialActionIntent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$phoneNumber"))
                startActivity(dialActionIntent)
            }
            R.id.btn_intent_action_open_link -> {
                val url = "https://roadmap.sh/android"
                val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(url))
                startActivity(browserIntent)
            }
            R.id.btn_intent_with_data -> {
                val intentWithData = Intent(this@ImplicitFirstActivity, ImplicitSecondActivity::class.java)
                _resultLauncher.launch(intentWithData)
            }
            R.id.btn_intent_with_data_camera -> {
                _checkCameraPermission()
            }
        }
    }
}