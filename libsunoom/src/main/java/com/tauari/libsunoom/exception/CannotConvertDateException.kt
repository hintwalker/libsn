package com.tauari.libsunoom.exception

import com.tauari.libsunoom.domain.GregorianDate
import com.tauari.libsunoom.domain.LuniSolarDate

class CannotConvertDateException(msg: String): Exception(msg) {
    constructor(fromDate: GregorianDate)
            : this("Cannot convert from Gregorian date ${fromDate.dayOfMonth}/${fromDate.month}/${fromDate.year}")
    constructor(fromDate: LuniSolarDate)
            : this("Cannot convert from Lunisolar date ${fromDate.dayOfMonth}/${fromDate.month}/${fromDate.year}")
}