package com.tauari.libsunoom.util

import android.widget.TextView
import com.tauari.libsunoom.enums.NguHanh
import com.tauari.libsunoom.usecase.getColorByNguHanh

fun setupTextColor(textView: TextView, nguHanh: NguHanh) {
    textView.setTextColor(getColorByNguHanh(textView.context, nguHanh))
}