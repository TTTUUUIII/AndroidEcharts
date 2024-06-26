package cn.touchair.androidecharts.interfaces

import androidx.annotation.StringDef

@StringDef(
    SeriesType.HEATMAP
)
annotation class SeriesType {
    companion object {
        internal const val HEATMAP = "heatmap"
    }
}
