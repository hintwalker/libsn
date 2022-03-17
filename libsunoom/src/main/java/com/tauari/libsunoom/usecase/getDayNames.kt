package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R

fun getDayNames(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.day_names
    )
}

fun getDayNamesShort(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.day_names_short
    )
}

fun getDayNamesVeryShort(context: Context): Array<String> {
    return context.resources.getStringArray(
        R.array.day_names_very_short
    )
}