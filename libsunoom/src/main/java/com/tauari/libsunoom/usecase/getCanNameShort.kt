package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R
import com.tauari.libsunoom.enums.Can

fun getCanNameShort(context: Context, can: Can): String {
    val names = context.resources.getStringArray(R.array.can_short_names)
    return names[can.ordinal]
}