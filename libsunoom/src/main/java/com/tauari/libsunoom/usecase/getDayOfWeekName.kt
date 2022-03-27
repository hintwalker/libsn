package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R
import com.tauari.libsunoom.enums.DayOfWeek

fun getDayOfWeekName(context: Context, dayOfWeek: DayOfWeek): String {
    val dayNames = context.resources.getStringArray(R.array.day_names)
    return dayNames[dayOfWeek.ordinal]
}