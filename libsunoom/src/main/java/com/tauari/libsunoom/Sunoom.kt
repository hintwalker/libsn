package com.tauari.libsunoom

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.usecase.conversion.getGregorianDateFromLuniSolar
import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian

object Sunoom {
    fun getGregorianFrom(date: LuniSolarDate) = getGregorianDateFromLuniSolar(date)
    fun getLuniSolarFrom(date: GregorianDate) = getLuniSolarDateFromGregorian(date)
}