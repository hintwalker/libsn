package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Chi

fun getChiOfLuniSolarYear(year: Int): Chi {
    return Chi.fromInt((year + 8) % 12)
}