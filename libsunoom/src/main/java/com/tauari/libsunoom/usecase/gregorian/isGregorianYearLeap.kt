package com.tauari.libsunoom.usecase.gregorian

fun isGregorianYearLeap(year: Int): Boolean {
    return (year % 4 == 0 && year % 100 != 0) || year % 400 == 0
}