package cn.touchair.androidecharts.annotations

import androidx.annotation.StringDef


@StringDef(
    OrientType.VERTICAL,
    OrientType.HORIZONTAL
)
annotation class OrientType {
    companion object {
        internal const val HORIZONTAL = "horizontal"
        internal const val VERTICAL = "vertical"
    }
}
