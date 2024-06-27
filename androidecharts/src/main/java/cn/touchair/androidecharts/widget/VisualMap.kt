package cn.touchair.androidecharts.widget

data class VisualMap(
    var min: Any? = null,
    var max: Any? = null,
    var calculable: Boolean = false,
    var realtime: Boolean = false,
    var inRange: Map<String, Any>? = null,
    var orient: String = "horizontal" /*"vertical"*/,
    var left: String = "auto",
    var top: String = "auto",
    var right: String = "auto",
    var bottom: String = "auto",

)