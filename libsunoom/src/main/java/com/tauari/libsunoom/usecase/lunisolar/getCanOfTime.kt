package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.enums.Chi

fun getCanOfTime(chiOfTime: Chi, canOfDayOfMonth: Can): Can {
    val data = arrayOf<Can>(
        Can.GIAP, Can.BINH, Can.MAU, Can.CANH, Can.NHAM,
        Can.GIAP, Can.BINH, Can.MAU, Can.CANH, Can.NHAM
    )
    val firstCan = data[canOfDayOfMonth.ordinal]
    val delta = chiOfTime.ordinal - Chi.TYS.ordinal
    var can = firstCan.ordinal + delta
    if(can > 9) {
        can -=10
    }
    return Can.fromInt(can)
}