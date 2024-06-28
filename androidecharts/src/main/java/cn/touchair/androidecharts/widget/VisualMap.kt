package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.Orient

data class VisualMap(
    val min: Any? = null,
    val max: Any? = null,
    val calculable: Boolean = false,
    val realtime: Boolean = false,
    val inRange: Map<String, Any>? = null,
    @Orient val orient: String = Orient.HORIZONTAL,
    val left: String = "auto",
    val top: String = "auto",
    val right: String = "auto",
    val bottom: String = "auto",
)