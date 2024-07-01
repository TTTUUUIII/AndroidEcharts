package cn.touchair.androidecharts.widget

data class Emphasis(
    var disabled: Boolean = false,
    var scale: Boolean? = null,
    var focus: String? = null,
    var blurScope: String? = null,
    val itemStyle: Map<String, Any>? = null
)