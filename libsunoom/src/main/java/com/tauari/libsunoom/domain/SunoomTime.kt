package com.tauari.libsunoom.domain

data class SunoomTime(
    var hour: Int,
    var minute: Int,
    var second: Int = 0
) {
    override fun toString(): String {
        return if(second == 0){
            String.format("%02d:%02d",hour,minute)
        } else {
            String.format("%02d:%02d:%02d",hour,minute,second)
        }
    }
}
