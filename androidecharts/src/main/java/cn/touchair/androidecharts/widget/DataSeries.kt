package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.SeriesType

class DataSeries<T>(
    val name: String,
    @SeriesType val type: String,
    val data: T,
    val emphasis: Map<String, Any>? = null,
    val progressive: Int? = null,
    val animation: Boolean = false
)