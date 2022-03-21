package com.tauari.libsunoom.usecase

import android.content.Context
import androidx.core.content.ContextCompat
import com.tauari.libsunoom.R
import com.tauari.libsunoom.enums.NguHanh

fun getColorByNguHanh(context: Context, nguHanh: NguHanh): Int {
    return when(nguHanh) {
        NguHanh.HOA -> ContextCompat.getColor(context, R.color.red_600_dark)
        NguHanh.THUY -> ContextCompat.getColor(context, R.color.grey_600_dark)
        NguHanh.MOC -> ContextCompat.getColor(context, R.color.green_500_dark)
        NguHanh.KIM -> ContextCompat.getColor(context, R.color.blue_grey_100_dark)
        NguHanh.THO -> ContextCompat.getColor(context, R.color.p_2_brown)
    }
}

/**
 * @param nguHanh Value of ngu hanh
 */
fun getColorByNguHanh(context: Context, nguHanh: Int): Int {
    return when(nguHanh) {
        NguHanh.HOA.value -> ContextCompat.getColor(context, R.color.red_600_dark)
        NguHanh.THUY.value -> ContextCompat.getColor(context, R.color.grey_600_dark)
        NguHanh.MOC.value -> ContextCompat.getColor(context, R.color.green_500_dark)
        NguHanh.KIM.value -> ContextCompat.getColor(context, R.color.blue_grey_100_dark)
        NguHanh.THO.value -> ContextCompat.getColor(context, R.color.p_2_brown)
        else -> {ContextCompat.getColor(context, android.R.color.white)}
    }
}