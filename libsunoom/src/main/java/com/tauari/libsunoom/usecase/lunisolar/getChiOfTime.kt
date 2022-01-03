package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Chi

fun getChiOfTime(hour: Int): Chi {
    val data = listOf<Chi>(
        Chi.TYS,
        Chi.SUU, Chi.SUU,
        Chi.DAN, Chi.DAN,
        Chi.MAO, Chi.MAO,
        Chi.THIN, Chi.THIN,
        Chi.TYJ, Chi.TYJ,
        Chi.NGO, Chi.NGO,
        Chi.MUI, Chi.MUI,
        Chi.THAN, Chi.THAN,
        Chi.DAU, Chi.DAU,
        Chi.TUAT, Chi.TUAT,
        Chi.HOI, Chi.HOI,
        Chi.TYS,Chi.TYS
    )
    if(hour < 0 || hour > 24) {
        throw Error()
    }
    return data[hour]
}