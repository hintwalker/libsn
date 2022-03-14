package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.exception.CannotConvertDateException
import com.tauari.libsunoom.usecase.conversion.getGregorianDateFromLuniSolar
import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian

@Throws(CannotConvertDateException::class)
fun getMaxLunarDatesOfMonth(month: Int, year: Int, isLeapMonth: Boolean, timeZomeOffset: Int): Int {
    val endLunarDate = LuniSolarDate(30, month, year, isLeapMonth, timeZomeOffset)
    val endSolarDate = getGregorianDateFromLuniSolar(endLunarDate)
        ?: throw CannotConvertDateException()
    val confirmLunarDate = getLuniSolarDateFromGregorian(endSolarDate) ?: throw CannotConvertDateException()
    return if(confirmLunarDate.dayOfMonth == 1){
        29
    } else {
        30
    }
}