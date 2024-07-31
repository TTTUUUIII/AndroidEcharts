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
        const val HEATMAP = "heatmap"
        const val LINE = "line"
        const val BAR = "bar"
        const val PIE = "pie"
    }
}
