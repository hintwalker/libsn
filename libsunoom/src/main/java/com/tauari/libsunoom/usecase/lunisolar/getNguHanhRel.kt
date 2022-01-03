package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.NguHanh
import com.tauari.libsunoom.enums.NguHanhRel

fun getNguHanhRel(element1: NguHanh, element2: NguHanh): NguHanhRel? {
    val data = HashMap<NguHanh, List<NguHanh>>()
    // sinh, khac, duoc sinh, bi khac
    data[NguHanh.THUY] = listOf(NguHanh.MOC, NguHanh.HOA, NguHanh.KIM, NguHanh.THO)
    data[NguHanh.MOC] = listOf(NguHanh.HOA, NguHanh.THO, NguHanh.THUY, NguHanh.KIM)
    data[NguHanh.KIM] = listOf(NguHanh.THUY, NguHanh.MOC, NguHanh.THO, NguHanh.HOA)
    data[NguHanh.THO] = listOf(NguHanh.KIM, NguHanh.THUY, NguHanh.HOA, NguHanh.MOC)
    data[NguHanh.HOA] = listOf(NguHanh.THO, NguHanh.KIM, NguHanh.MOC, NguHanh.THUY)
    val listOfRel = data[element1]
    return if(listOfRel == null) {
        null
    } else {
        val relData = listOf(NguHanhRel.SINH, NguHanhRel.KHAC, NguHanhRel.DUOC_SINH, NguHanhRel.BI_KHAC)
        val index = listOfRel.indexOf(element2)
        if(index < 0) {
            return null
        }
        relData[index]
    }

}