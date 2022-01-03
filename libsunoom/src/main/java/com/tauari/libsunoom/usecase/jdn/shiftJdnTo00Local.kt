package com.tauari.libsunoom.usecase.jdn

import com.tauari.libsunoom.usecase.gregorian.getGregorianDateFromJdnLocal

fun shiftJdnTo00Local(jdn: Double, timeoZoneOffset: Int): Double {
    val date = getGregorianDateFromJdnLocal(jdn, timeoZoneOffset)
    return getJdnAt00Local(date)
}