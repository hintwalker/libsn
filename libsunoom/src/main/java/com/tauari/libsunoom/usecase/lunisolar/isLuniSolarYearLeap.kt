package com.tauari.libsunoom.usecase.lunisolar

fun isLuniSolarYearLeap(year: Int): Boolean {
    val data = listOf(0, 3, 6, 9, 11, 14, 17)
    return data.contains(year % 19)
}