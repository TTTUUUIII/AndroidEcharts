package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.annotations.SeriesType
import cn.touchair.androidecharts.style.LineStyle

class Series<T>(
    @SeriesType val type: String,
    var data: T,
    val emphasis: Emphasis? = null,
    val progressive: Int? = null,
    val animation: Boolean? = null,
    val name: String? = null,
    var areaStyle: Any? = null,
    var radius: String? = null,
    val yAxisIndex: Int? = null,
    val xAxisIndex: Int? = null,
    val smooth: Boolean = false,
    val lineStyle: LineStyle? = null,
    val showSymbol: Boolean = true
)