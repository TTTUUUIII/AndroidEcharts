package cn.touchair.androidecharts.annotations

import androidx.annotation.StringDef

@StringDef(
    SeriesType.HEATMAP,
    SeriesType.LINE,
    SeriesType.BAR,
    SeriesType.PIE
)
annotation class SeriesType {
    companion object {
        internal const val HEATMAP = "heatmap"
        internal const val LINE = "line"
        internal const val BAR = "bar"
        internal const val PIE = "pie"
    }
}
