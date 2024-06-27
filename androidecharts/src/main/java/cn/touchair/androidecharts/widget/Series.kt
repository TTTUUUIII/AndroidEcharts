package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.style.AreaStyle

class Series<T>(
    @SeriesType val type: String,
    val data: T,
    val emphasis: Emphasis? = null,
    val progressive: Int? = null,
    val animation: Boolean = false,
    val name: String = "",
    var areaStyle: AreaStyle? = null,
    var radius: String? = null
)