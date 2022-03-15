package com.tauari.libsunoom.usecase

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.domain.SunoomDate

fun isOutOfTable(date: GregorianDate, targetMonth: Int): Boolean {
    return date.month != targetMonth
}

fun isOutOfTable(date: LuniSolarDate, targetMonth: Int): Boolean {
    return date.month != targetMonth
}