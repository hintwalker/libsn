package com.tauari.libsunoom.domain

data class LuniSolarMonth(
    var index: Int,
    val firstDateInGregorianDate: GregorianDate,
    var value: Int,
    var isLeap: Boolean,
    var jdnOfFirstDate: Double
)
