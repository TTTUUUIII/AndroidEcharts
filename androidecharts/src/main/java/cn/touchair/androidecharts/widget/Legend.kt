package cn.touchair.androidecharts.widget

import cn.touchair.androidecharts.interfaces.Orient

data class Legend (
    val show: Boolean = true,
    val z: Int? = null,
    val type: String? = null,
    @Orient val orient: String? = null,
    val left: String? = null,
    val right: String? = null,
    val top: String? = null,
    val bottom: String? = null,
    val padding: Int? = null
) {
    companion object {
        const val TYPE_PLAIN = "plain"
        const val TYPE_SCROLL = "scroll"
    }
}
