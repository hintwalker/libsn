package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.exception.CannotConvertDateException
import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian
import com.tauari.libsunoom.usecase.gregorian.getTodayInGregorian
import java.util.*

@Throws(CannotConvertDateException::class)
fun isToday(date: LuniSolarDate, timeZone: TimeZone): Boolean {
    val today = getTodayInGregorian(timeZone)
    val luniSolarDate = getLuniSolarDateFromGregorian(today)
        ?: throw CannotConvertDateException(today)
    return luniSolarDate.areTheSame(date)
}