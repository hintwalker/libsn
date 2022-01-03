package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.enums.DayOfWeek
import java.util.*

fun getDayOfWeek(gregorianDate: GregorianDate): DayOfWeek {
    val calendar = GregorianCalendar()
    calendar.set(gregorianDate.year, gregorianDate.month - 1, gregorianDate.dayOfMonth)
    return DayOfWeek.fromInt(calendar.get(GregorianCalendar.DAY_OF_WEEK))
}