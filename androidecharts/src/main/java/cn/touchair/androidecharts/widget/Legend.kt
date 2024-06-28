package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.Orient

data class Legend (
    val show: Boolean = true,
    val z: Int = 2,
    val type: String = TYPE_PLAIN,
    @Orient val orient: String = Orient.HORIZONTAL,
    val left: String = "auto",
    val right: String = "auto",
    val top: String = "auto",
    val bottom: String = "auto",
    val padding: Int = 5
) {
    companion object {
        const val TYPE_PLAIN = "plain"
        const val TYPE_SCROLL = "scroll"
    }
}
