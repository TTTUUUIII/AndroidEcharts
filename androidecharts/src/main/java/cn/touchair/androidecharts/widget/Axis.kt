package cn.touchair.androidecharts.widget

class Axis<T>(
    val data: Array<T>? = null,
    val type: String = TYPE_CATEGORY,
    var boundaryGap: Boolean = true
) {
    companion object {
        const val TYPE_CATEGORY = "category"
        const val TYPE_VALUE = "value"
    }
}