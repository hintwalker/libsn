package com.tauari.libsunoom

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate
import com.tauari.libsunoom.usecase.conversion.getGregorianDateFromLuniSolar
import com.tauari.libsunoom.usecase.conversion.getLuniSolarDateFromGregorian
import com.tauari.libsunoom.usecase.lunisolar.getLeapMonthValue
import org.junit.Assert.assertEquals
import org.junit.Test

class TestGregorianToLunisolar {
    private val timeZoneOffset = 7

    /**
     * This lunisolar year is leap, and leap month is 10
     *
     * Vi tinh ngay neu moon tu ngay 31/12
     */
    @Test
    fun checkTheLuniSolarYear2166() {
        val gregDate = GregorianDate(28,5,2166, timeZoneOffset)
        val luniDate = getLuniSolarDateFromGregorian(gregDate)
        assertEquals("dayOfMonth",29, luniDate?.dayOfMonth)
        assertEquals("month",4, luniDate?.month)
        assertEquals("year", 2166, luniDate?.year)
    }

    @Test
    fun checkIfTheLuniSolarYear2166_leapMonth() {
        val gregDate = GregorianDate(28,1,2167, timeZoneOffset)
        val luniDate = getLuniSolarDateFromGregorian(gregDate)
        assertEquals("dayOfMonth",8, luniDate?.dayOfMonth)
        assertEquals("month",12, luniDate?.month)
        assertEquals("year", 2166, luniDate?.year)

    }

    @Test
    fun checkLeapMonth() {
        val gregDate = GregorianDate(28,5,2166, timeZoneOffset)
        assertEquals("leap month is 10", 10, getLeapMonthValue(gregDate))
    }

    @Test
    fun checkIfLunisolarYear7_12_1987() {
        val gregDate = GregorianDate(28,1,2167, timeZoneOffset)
        val luniDate = getLuniSolarDateFromGregorian(gregDate)
        assertEquals("dayOfMonth",8, luniDate?.dayOfMonth)
        assertEquals("month",12, luniDate?.month)
        assertEquals("year", 2166, luniDate?.year)
    }

    @Test
    fun lunarToSolar() {
        var luniDate = LuniSolarDate(17,10,1987, false, timeZoneOffset)
        var gregorianDate = getGregorianDateFromLuniSolar(luniDate)
        assertEquals("dayOfMonth",7, gregorianDate?.dayOfMonth)
        assertEquals("month",12, gregorianDate?.month)
        assertEquals("year", 1987, gregorianDate?.year)

        luniDate = LuniSolarDate(7,12,2166, false, timeZoneOffset)
        gregorianDate = getGregorianDateFromLuniSolar(luniDate)
        assertEquals("dayOfMonth",27, gregorianDate?.dayOfMonth)
        assertEquals("month",1, gregorianDate?.month)
        assertEquals("year", 2167, gregorianDate?.year)

        luniDate = LuniSolarDate(19,9,2167, false, timeZoneOffset)
        gregorianDate = getGregorianDateFromLuniSolar(luniDate)
        assertEquals("dayOfMonth",31, gregorianDate?.dayOfMonth)
        assertEquals("month",10, gregorianDate?.month)
        assertEquals("year", 2167, gregorianDate?.year)
    }

    @Test
    fun dec1965() {
        val gregDate = GregorianDate(5,12,1965, timeZoneOffset)
        val luniDate = getLuniSolarDateFromGregorian(gregDate)
        assertEquals("year",1965, luniDate?.year)
        assertEquals("month",11, luniDate?.month)
        assertEquals("day",13, luniDate?.dayOfMonth)
    }
}