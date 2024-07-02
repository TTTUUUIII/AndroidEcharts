package cn.touchair.androidecharts.annotations

import androidx.annotation.StringDef


@StringDef(
    OrientType.VERTICAL,
    OrientType.HORIZONTAL
)
annotation class OrientType {
    companion object {
        const val HORIZONTAL = "horizontal"
        const val VERTICAL = "vertical"
    }
}
