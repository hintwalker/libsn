package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R

fun getMonthNames(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.month_names
    )
}

fun getMonthNamesShort(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.month_names_short
    )
}

fun getMonthNamesVeryShort(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.month_names_very_short
    )
}