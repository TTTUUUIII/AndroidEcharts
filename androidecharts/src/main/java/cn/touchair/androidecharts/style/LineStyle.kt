package cn.touchair.androidecharts.style

import cn.touchair.androidecharts.annotations.LineType

data class LineStyle(
    val color: String? = null,
    val width: Int = 2,
    @LineType val type: String = LineType.SOLID,
    val shadowBlur: String? = null,
    val shadowColor: String? = null,
    val opacity: Float = 1F
)