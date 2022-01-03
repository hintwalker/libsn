package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.enums.Chi
import com.tauari.libsunoom.usecase.jdn.getJdnAt12AmUT

fun getChiOfGregorianDay(date: GregorianDate): Chi {
    val jdn = getJdnAt12AmUT(date.dayOfMonth, date.month, date.year)
    return Chi.fromInt((jdn + 1) % 12)
}