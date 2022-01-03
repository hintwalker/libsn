package com.tauari.libsunoom.usecase.conversion

import com.tauari.libsunoom.domain.PairOfFirstJdnNov
import com.tauari.libsunoom.usecase.jdn.getFirstJdnInNov
import com.tauari.libsunoom.usecase.jdn.shiftJdnTo00Local

fun getPairOfFirstJdnApprox(gregorianYear: Int, timeZoneOffset: Int): PairOfFirstJdnNov {
    val jdnNovPrev = getFirstJdnInNov(gregorianYear - 1, timeZoneOffset)
    val jdnNovCurrent = getFirstJdnInNov(gregorianYear, timeZoneOffset)
    val jdnNovPrevAt00 = shiftJdnTo00Local(jdnNovPrev, timeZoneOffset)
    val jdnNovCurrentAt00 = shiftJdnTo00Local(jdnNovCurrent, timeZoneOffset)
    return PairOfFirstJdnNov(jdnNovPrevAt00, jdnNovCurrentAt00)
}