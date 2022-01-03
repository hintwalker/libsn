package com.tauari.libsunoom.usecase.sun

import kotlin.math.PI
import kotlin.math.sin

fun getSunLongitudeFromJdn(jdn: Double): Double {
    val T =
        (jdn - 2451545.0) / 36525 // Time in Julian centuries from 2000-01-01 12:00:00 GMT

    val T2 = T * T
    val dr: Double = PI / 180 // degree to radian

    val M =
        357.52910 + 35999.05030 * T - 0.0001559 * T2 - 0.00000048 * T * T2 // mean anomaly, degree

    val L0 =
        280.46645 + 36000.76983 * T + 0.0003032 * T2 // mean longitude, degree

    var DL =
        (1.914600 - 0.004817 * T - 0.000014 * T2) * sin(dr * M)
    DL += (0.019993 - 0.000101 * T) * Math.sin(dr * 2 * M) + 0.000290 * sin(
        dr * 3 * M
    )
    var L = L0 + DL // true longitude, degree
    L *= dr
    L -= PI * 2 * ((L / (PI * 2)).toInt()) // Normalize to (0, 2*PI)
    while(L<0){
        L+=2* PI
    }
    while(L>2* PI){
        L-=2* PI
    }
    return L
}