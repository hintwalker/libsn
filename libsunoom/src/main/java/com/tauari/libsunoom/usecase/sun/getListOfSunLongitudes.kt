package com.tauari.libsunoom.usecase.sun

fun getListOfSunLongitudes(firstJdnPerMonths: List<Double>): List<Double> {
    val result = arrayListOf<Double>()
    firstJdnPerMonths.forEach { jdn ->
        result.add(getSunLongitudeFromJdn(jdn))
    }
    return result
}