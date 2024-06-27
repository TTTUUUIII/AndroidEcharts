package cn.touchair.androidecharts.interfaces

import androidx.annotation.StringDef

@StringDef(
    SeriesType.HEATMAP,
    SeriesType.LINE,
    SeriesType.BAR
)
annotation class SeriesType {
    companion object {
        internal const val HEATMAP = "heatmap"
        internal const val LINE = "line"
        internal const val BAR = "bar"
    }
}
