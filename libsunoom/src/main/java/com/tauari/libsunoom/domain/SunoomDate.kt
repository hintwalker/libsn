package com.tauari.libsunoom.domain

data class SunoomDate(var gregorianDate: GregorianDate, var luniSolarDate: LuniSolarDate) {
    override fun toString(): String {
        return "$gregorianDate , $luniSolarDate (AL)"
    }
}
