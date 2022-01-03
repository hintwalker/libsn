package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.constants.TimeConstant.HOURS_PER_DAY
import com.tauari.libsunoom.domain.GregorianDate

fun getGregorianDateFromJdnLocal(jdn: Double, timeZoneOffset: Int): GregorianDate {
    val date = dateFromJdnAtUt(jdn + timeZoneOffset / HOURS_PER_DAY);
    date.timeZoneOffset = timeZoneOffset
    return date
}

private fun dateFromJdnAtUt(jdn: Double): GregorianDate {
    val A: Int
    val alpha: Int
    val C: Int
    val E: Int
    val dd: Int
    val yyyy: Int
    val F: Double
    val Z: Int = (jdn + 0.5).toInt()
    F = jdn + 0.5 - Z
    if (Z < 2299161) {
        A = Z
    } else {
        alpha = ((Z - 1867216.25) / 36524.25).toInt()
        A = Z + 1 + alpha - (alpha / 4).toInt()
    }
    val B: Int = A + 1524
    C = ((B - 122.1) / 365.25).toInt()
    val D: Int = (365.25 * C).toInt()
    E = ((B - D) / 30.6001).toInt()
    dd = (B - D - (30.6001 * E).toInt() + F).toInt()
    val mm: Int = if (E < 14) {
        E - 1
    } else {
        E - 13
    }
    yyyy = if (mm < 3) {
        C - 4715
    } else {
        C - 4716
    }
    return GregorianDate(dd, mm, yyyy, 0)
}