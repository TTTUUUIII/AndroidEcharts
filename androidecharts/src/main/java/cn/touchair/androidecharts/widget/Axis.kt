package cn.touchair.androidecharts.widget

open class Axis<T>(
    val data: T? = null,
    val type: String? = null,
    val gridIndex: Int? = null,
    val min: Number? = null,
    val max: Number? = null,
    val name: String? = null,
    val nameLocation: String?= null,
    var boundaryGap: Boolean? = null,
    val axisLabel: Map<Any, Any>? = null,
) {
    companion object {
        const val TYPE_CATEGORY = "category"
        const val TYPE_VALUE = "value"
    }
}