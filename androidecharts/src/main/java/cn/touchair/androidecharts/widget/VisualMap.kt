package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.Orient

data class VisualMap(
    val min: Any? = null,
    val max: Any? = null,
    val calculable: Boolean? = null,
    val realtime: Boolean? = null,
    val inRange: Map<String, Any>? = null,
    @Orient val orient: String? = null,
    val left: String? = null,
    val top: String? = null,
    val right: String? = null,
    val bottom: String? = null,
)