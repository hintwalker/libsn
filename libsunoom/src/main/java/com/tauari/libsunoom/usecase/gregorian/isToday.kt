package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import java.util.*

fun isToday(date: GregorianDate, timeZone: TimeZone): Boolean {
    val today = getTodayInGregorian(timeZone)
    return date.areTheSame(today)
}