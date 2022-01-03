package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import java.util.*

fun GetCalendarFromGregorianDate(date: GregorianDate, timeZone: TimeZone): Calendar {
    val dateNow = GregorianCalendar.getInstance(timeZone)
    dateNow.set(date.year, date.month - 1, date.dayOfMonth)
    return dateNow
}