package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.SunoomDate

fun isFirstDateOfMonth(date: SunoomDate): Boolean {
    return isFirstDateOfMonth(date.gregorianDate)
            || isFirstDateOfMonth(date.luniSolarDate)
}

fun isFirstDateOfMonth(date: GregorianDate): Boolean {
    return date.dayOfMonth == 1
}

fun isFirstDateOfMonth(date: LuniSolarDate): Boolean {
    return date.dayOfMonth == 1
}