package cn.touchair.androidecharts.widget

class Axis<T>(
    val data: T? = null,
    val type: String? = null,
    val gridIndex: Int? = null,
    val name: String? = null,
    var boundaryGap: Boolean? = null
) {
    companion object {
        const val TYPE_CATEGORY = "category"
        const val TYPE_VALUE = "value"
    }
}