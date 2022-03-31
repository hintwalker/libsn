package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import java.util.*

fun nextGregorianDate(oldDate: GregorianDate, delta: Int = 1): GregorianDate {
    val calendar = GregorianCalendar.getInstance()
    oldDate.run {
        calendar.set(year, month-1, dayOfMonth)
    }
    calendar.add(Calendar.DAY_OF_MONTH, delta)
    return GregorianDate(
        calendar.get(Calendar.DAY_OF_MONTH),
        calendar.get(Calendar.MONTH) + 1,
        calendar.get(Calendar.YEAR),
        oldDate.timeZoneOffset
    )
}