package com.tauari.libsunoom.usecase

import android.content.Context
import com.tauari.libsunoom.R
import com.tauari.libsunoom.enums.Chi

fun getChiName(context: Context, chi: Chi): String {
    val chiNames = context.resources.getStringArray(R.array.chi_names)
    return chiNames[chi.ordinal]
}