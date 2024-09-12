package cn.touchair.androidecharts.widget

open class ToolTip(
    val show: Boolean = true,
    val trigger: String = TRIGGER_ITEM,
    val formatter: String? = null
) {
    companion object {
        const val TRIGGER_ITEM = "item"
        const val TRIGGER_AXIS = "axis"
        const val TRIGGER_NONE = "none"
    }
}