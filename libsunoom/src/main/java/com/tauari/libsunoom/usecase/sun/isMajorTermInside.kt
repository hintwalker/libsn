package com.tauari.libsunoom.usecase.sun

import kotlin.math.PI

fun isMajorTermInside(index: Int, current: Double, before: Double): Boolean {
    val majorTerms = listOf(0.0, PI /6, 2* PI /6, 3* PI /6,
        4* PI /6, 5* PI /6, PI, 7* PI /6,
        8* PI /6, 9* PI /6, 10* PI /6, 11* PI /6)
    var result = false
    majorTerms.forEach {
        result = result || if(current > before) {
            it >= before && it < current
        } else {
            it >= before || it < current
        }
    }
    return result
}