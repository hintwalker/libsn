package com.tauari.libsunoom.usecase.jdn

import kotlin.math.PI
import kotlin.math.sin

fun getJdnOnNewMoonDay(k: Int): Double {
    val T = k / 1236.85 // Time in Julian centuries from 1900 January 0.5

    val T2 = T * T
    val T3 = T2 * T
    val dr = PI / 180
    var Jd1 =
        2415020.75933 + 29.53058868 * k + 0.0001178 * T2 - 0.000000155 * T3
    Jd1 += 0.00033 * sin((166.56 + 132.87 * T - 0.009173 * T2) * dr) // Mean new moon

    val M =
        359.2242 + 29.10535608 * k - 0.0000333 * T2 - 0.00000347 * T3 // Sun's mean anomaly

    val Mpr =
        306.0253 + 385.81691806 * k + 0.0107306 * T2 + 0.00001236 * T3 // Moon's mean anomaly

    val F =
        21.2964 + 390.67050646 * k - 0.0016528 * T2 - 0.00000239 * T3 // Moon's argument of latitude

    var C1 =
        (0.1734 - 0.000393 * T) * sin(M * dr) + 0.0021 * sin(2 * dr * M)
    C1 = C1 - 0.4068 * sin(Mpr * dr) + 0.0161 * sin(dr * 2 * Mpr)
    C1 -= 0.0004 * sin(dr * 3 * Mpr)
    C1 = C1 + 0.0104 * sin(dr * 2 * F) - 0.0051 * sin(dr * (M + Mpr))
    C1 = C1 - 0.0074 * sin(dr * (M - Mpr)) + 0.0004 * sin(dr * (2 * F + M))
    C1 = C1 - 0.0004 * sin(dr * (2 * F - M)) - 0.0006 * sin(
        dr * (2 * F + Mpr)
    )
    C1 += 0.0010 * sin(dr * (2 * F - Mpr)) + 0.0005 * sin(
        dr * (2 * Mpr + M)
    )
    val deltaT: Double = if (T < -11) {
        0.001 + 0.000839 * T + 0.0002261 * T2 - 0.00000845 * T3 - 0.000000081 * T * T3
    } else {
        -0.000278 + 0.000265 * T + 0.000262 * T2
    }
    return Jd1 + C1 - deltaT
}