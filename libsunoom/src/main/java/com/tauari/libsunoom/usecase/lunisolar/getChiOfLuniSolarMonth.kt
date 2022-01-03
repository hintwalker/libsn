package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Chi

fun getChiOfLuniSolarMonth(month: Int): Chi {
    return Chi.fromInt((month + 1) % 12)
}