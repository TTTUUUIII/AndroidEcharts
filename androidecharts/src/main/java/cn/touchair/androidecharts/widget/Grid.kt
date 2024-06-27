package cn.touchair.androidecharts.widget

data class Grid(
    val show: Boolean = false,
    val z: Int = 2,
    val left: String = "10%",
    val top: String = "15%",
    val right: String = "10%",
    var bottom: String = "60",
    var width: String = "auto",
    var height: String = "auto"
)