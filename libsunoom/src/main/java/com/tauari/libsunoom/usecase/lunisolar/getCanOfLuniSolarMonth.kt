package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can

fun getCanOfLuniSolarMonth(month: Int, year: Int): Can {
    return Can.fromInt ((year * 12 + month + 3) % 10)
}