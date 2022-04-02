package com.tauari.libsunoom.usecase.gregorian

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.SunoomTime
import com.tauari.libsunoom.enums.Chi
import com.tauari.libsunoom.usecase.jdn.getJdnAt12AmUT

fun getChiOfGregorianDay(date: GregorianDate, time: SunoomTime?): Chi {
    var jdn = getJdnAt12AmUT(date.dayOfMonth, date.month, date.year)
    if(time?.hour == 23) {
        jdn += 1
    }
    return Chi.fromInt((jdn + 1) % 12)
}