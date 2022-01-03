package com.tauari.libsunoom.usecase.lunisolar

import com.tauari.libsunoom.enums.Can
import com.tauari.libsunoom.enums.Chi

fun getBanMenhHoaGiap(canOfYear: Can, chiOfYear: Chi): String? {
    val data = getHoaGiapData()
    val key = "${canOfYear.ordinal},${chiOfYear.ordinal}"
    return data[key]
}

private fun getHoaGiapData(): Map<String, String> {
    val data = HashMap<String, String>()
    data.set("0,0", "Hải Trung Kim");
    data.set("1,1", "Hải Trung Kim");
    data.set("2,2", "Lô Trung Hỏa");
    data.set("3,3", "Lô Trung Hỏa");
    data.set("4,4", "Đại Lâm Mộc");
    data.set("5,5", "Đại Lâm Mộc");
    data.set("6,6", "Lộ Bàng Thổ");
    data.set("7,7", "Lộ Bàng Thổ");
    data.set("8,8", "Kiếm Phong Kim");
    data.set("9,9", "Kiếm Phong Kim");
    data.set("0,10", "Sơn Đầu Hỏa");
    data.set("1,11", "Sơn Đầu Hỏa");
    data.set("2,0", "Giản Hạ Thuỷ");
    data.set("3,1", "Giản Hạ Thuỷ");
    data.set("4,2", "Thành Đầu Thổ");
    data.set("5,3", "Thành Đầu Thổ");
    data.set("6,4", "Bạch Lạp Kim");
    data.set("7,5", "Bạch Lạp Kim");
    data.set("8,6", "Dương Liễu Mộc");
    data.set("9,7", "Dương Liễu Mộc");
    data.set("0,8", "Tuyền Trung Thuỷ");
    data.set("1,9", "Tuyền Trung Thuỷ");
    data.set("2,10", "Ốc Thượng Thổ");
    data.set("3,11", "Ốc Thượng Thổ");
    data.set("4,0", "Tích Lịch Hỏa");
    data.set("5,1", "Tích Lịch Hỏa");
    data.set("6,2", "Tùng Bách Mộc");
    data.set("7,3", "Tùng Bách Mộc");
    data.set("8,4", "Trường Lưu Thuỷ");
    data.set("9,5", "Trường Lưu Thuỷ");
    data.set("0,6", "Sa Trung Kim");
    data.set("1,7", "Sa Trung Kim");
    data.set("2,8", "Sơn Hạ Hỏa");
    data.set("3,9", "Sơn Hạ Hỏa");
    data.set("4,10", "Bình Địa Mộc");
    data.set("5,11", "Bình Địa Mộc");
    data.set("6,0", "Bích Thượng Thổ");
    data.set("7,1", "Bích Thượng Thổ");
    data.set("8,2", "Kim Bạch Kim");
    data.set("9,3", "Kim Bạch Kim");
    data.set("0,4", "Phú Đăng Hỏa");
    data.set("1,5", "Phú Đăng Hỏa");
    data.set("2,6", "Thiên Hà Thuỷ");
    data.set("3,7", "Thiên Hà Thuỷ");
    data.set("4,8", "Đại Dịch Thổ");
    data.set("5,9", "Đại Dịch Thổ");
    data.set("6,10", "Thoa Xuyến Kim");
    data.set("7,11", "Thoa Xuyến Kim");
    data.set("8,0", "Tang Chá Mộc");
    data.set("9,1", "Tang Chá Mộc");
    data.set("0,2", "Đại Khê Thuỷ");
    data.set("1,3", "Đại Khê Thuỷ");
    data.set("2,4", "Sa Trung Thổ");
    data.set("3,5", "Sa Trung Thổ");
    data.set("4,6", "Thiên Thượng Hỏa");
    data.set("5,7", "Thiên Thượng Hỏa");
    data.set("6,8", "Bạch Lựu Mộc");
    data.set("7,9", "Bạch Lựu Mộc");
    data.set("8,10", "Đại Hải Thuỷ");
    data.set("9,11", "Đại Hải Thuỷ");
    return data
}