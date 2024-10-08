package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.annotations.OrientType

open class VisualMap(
    val show: Boolean = true,
    val type: String? = null,
    val min: Any? = null,
    val max: Any? = null,
    val range: FloatArray? = null,
    val calculable: Boolean? = null,
    val realtime: Boolean? = null,
    val inRange: Map<String, Any>? = null,
    @OrientType val orient: String = OrientType.VERTICAL,
    val left: String? = null,
    val top: String? = null,
    val right: String? = null,
    val bottom: String? = null,
    val itemHeight: String? = null,
    val itemWidth: String? = null,
)