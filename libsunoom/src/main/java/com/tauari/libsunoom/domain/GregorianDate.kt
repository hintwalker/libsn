package com.tauari.libsunoom.domain

data class GregorianDate(var dayOfMonth: Int, var month: Int, var year: Int, var timeZoneOffset: Int) {
    override fun toString(): String {
        return "$dayOfMonth-$month-$year"
    }
}
