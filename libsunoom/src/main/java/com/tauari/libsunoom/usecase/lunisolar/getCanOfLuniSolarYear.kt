package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can

fun getCanOfLuniSolarYear(year: Int): Can {
    return Can.fromInt(( year + 6) % 10)
}