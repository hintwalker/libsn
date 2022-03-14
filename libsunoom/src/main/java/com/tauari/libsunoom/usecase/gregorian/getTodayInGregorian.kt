package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.usecase.getTimeZoneOffsetInHour
import java.util.*

fun getTodayInGregorian(timeZone: TimeZone): GregorianDate {
    val today = GregorianCalendar.getInstance(timeZone)
    return GregorianDate(
        today.get(Calendar.DAY_OF_MONTH),
        today.get(Calendar.MONTH) + 1,
        today.get(Calendar.YEAR),
        getTimeZoneOffsetInHour(timeZone)
    )
}