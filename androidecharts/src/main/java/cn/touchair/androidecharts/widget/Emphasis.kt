package cn.touchair.androidecharts.widget

data class Emphasis(
    var disabled: Boolean = false,
    var scale: Boolean = true,
    var focus: String = "none",
    var blurScope: String = "coordinateSystem",
    @Transient val shadow: Boolean = false,
    val itemStyle: Map<String, Any>? = if (shadow) mapOf(
        "shadowBlur" to 10,
        "shadowColor" to "rgba(0, 0, 0, 0.5)"
    ) else null
)