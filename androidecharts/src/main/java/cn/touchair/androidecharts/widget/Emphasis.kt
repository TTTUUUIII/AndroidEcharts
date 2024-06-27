package cn.touchair.androidecharts.widget

data class Emphasis(
    var disabled: Boolean = false,
    var scale: Boolean = true,
    var focus: String = "none",
    var blurScope: String = "coordinateSystem"
)