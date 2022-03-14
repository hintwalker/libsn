package com.tauari.libsunoom.exception

import com.tauari.libsunoom.domain.GregorianDate

class CannotConvertDateException(msg: String): Exception(msg) {
    constructor(fromDate: GregorianDate)
            : this("Cannot convert from gregorian date ${fromDate.dayOfMonth}/${fromDate.month}/${fromDate.year}")
}