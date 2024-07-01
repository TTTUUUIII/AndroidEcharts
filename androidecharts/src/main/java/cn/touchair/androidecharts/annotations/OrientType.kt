package cn.touchair.androidecharts.annotations

import androidx.annotation.StringDef


@StringDef(
    Orient.VERTICAL,
    Orient.HORIZONTAL
)
annotation class Orient {
    companion object {
        internal const val HORIZONTAL = "horizontal"
        internal const val VERTICAL = "vertical"
    }
}
