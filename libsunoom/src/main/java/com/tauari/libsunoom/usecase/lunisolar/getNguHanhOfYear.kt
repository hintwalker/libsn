package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.enums.Chi
import com.tauari.libsunoom.enums.NguHanh

fun getBanMenh(canOfYear: Can, chiOfYear: Chi): NguHanh {
    var sum = getValueOfCan(canOfYear) + getValueOfChi(chiOfYear)
    if(sum > 5) {
        sum -= 5
    }
    return getNguHanhFromSum(sum)
}

private fun getValueOfChi(chiOfYear: Chi): Int {
    val data = listOf(0,0,1,1,2,2,0,0,1,1,2,2)
    return data[chiOfYear.ordinal]
}

private fun getValueOfCan(canOfYear: Can): Int {
    val data = listOf(1,1,2,2,3,3,4,4,5,5)
    return data[canOfYear.ordinal]
}

private fun getNguHanhFromSum(sum: Int): NguHanh {
    if(sum < 1 || sum > 5) {
        throw Error()
    }
    val data = listOf(NguHanh.KIM, NguHanh.THUY, NguHanh.HOA, NguHanh.THO, NguHanh.MOC)
    return data[sum-1]
}