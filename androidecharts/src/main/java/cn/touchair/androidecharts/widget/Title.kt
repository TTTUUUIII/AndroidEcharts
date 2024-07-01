package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.annotations.FontStyle

data class Title(
    var text: String,
    private var show: Boolean = true,
    var link: String? = null,
    var target: String? = null,
    @FontStyle var fontStyle: String? = null,
    var fontSize: Int? = null,
    var left: String? = null,
    var right: String? = null,
    var top: String? = null,
    var bottom: String? = null,
    var subtext: String? = null
) {
}