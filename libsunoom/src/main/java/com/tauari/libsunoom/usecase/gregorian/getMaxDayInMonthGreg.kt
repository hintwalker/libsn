package com.tauari.libsunoom.usecase.gregorian

fun getMaxDayInMonthGreg(month: Int, year: Int): Int {
    val isLeapYear = isGregorianYearLeap(year)
    val fullMonths = arrayOf(1,3,5,7,8,10,12)
    if(month == 2) {
        return if(isLeapYear) {
            29
        } else {
            28
        }
    }
    return if(month in fullMonths) {
        31
    } else {
        30
    }
}