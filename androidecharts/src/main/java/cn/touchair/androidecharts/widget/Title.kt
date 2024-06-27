package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.FontStyle

data class Title(
    var text: String,
    private var show: Boolean = true,
    var link: String = "",
    var target: String = "blank",
    @FontStyle var fontStyle: String = FontStyle.NORMAL,
    var fontSize: Int = 18,
    var left: String = "auto",
    var right: String = "auto",
    var top: String = "auto",
    var bottom: String = "auto",
    var subtext: String = ""
) {
}