package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R
import com.tauari.libsunoom.enums.Can

fun getCanName(context: Context, can: Can): String {
    val canNames = context.resources.getStringArray(R.array.can_names)
    return canNames[can.ordinal]
}