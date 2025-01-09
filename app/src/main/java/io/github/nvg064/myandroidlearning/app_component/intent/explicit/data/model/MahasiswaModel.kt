package io.github.nvg064.myandroidlearning.app_component.intent.explicit.data.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class MahasiswaModel(
    val name: String?,
    val nim: String,
    val semester: Int,
    val isGraduate: Boolean
) : Parcelable
