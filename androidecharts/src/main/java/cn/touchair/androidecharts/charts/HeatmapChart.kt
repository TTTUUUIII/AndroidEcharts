package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.EChart
import cn.touchair.androidecharts.common.linspace
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series
import cn.touchair.androidecharts.widget.Title
import cn.touchair.androidecharts.widget.VisualMap
import kotlin.math.ceil
import kotlin.math.floor

class HeatmapChart private constructor(
    data: Array<Array<Float>>,
): EChart() {

    var visualMap: VisualMap? = null

    val series: Series<Array<Array<Float>>> = Series(
        SeriesType.HEATMAP,
        data,
        emphasis = Emphasis(),
        progressive = 1000,
        animation = false
    )

    class Builder(
        private var data: Array<Array<Float>>,
    ): EChart.Builder() {
        private var min: Any = 0F
        private var max: Any = 0F
        private var calculable: Boolean = false
        private var xMin: Number = 0
        private var xMax: Number = data.size
        private var yMin: Number = 0
        private var yMax: Number = data[0].size

        /**
         * @param min Any
         * @param max Any
         * @return EChartHeatMap.Builder
         */
        fun range(min: Any, max: Any): Builder {
            this.min = min
            this.max = max
            return this
        }

        fun <T: Number>xRange(min: T, max: T): Builder {
            xMin = min
            xMax = max
            return this
        }

        fun <T: Number>yRange(min: T, max: T): Builder {
            yMin = min
            yMax = max
            return this
        }

        override fun build(): HeatmapChart {
            if (max == min) {
                min = floor(data.minOf { it.min() })
                max = ceil(data.maxOf { it.max() })
            }
            if (min is Number && max is Number) {
                calculable = true
            }

            val heatmap = HeatmapChart(data = remap(data))

            heatmap.grid = grid
            heatmap.title = title
            heatmap.tooltip = tooltip

            /*X axis*/
            heatmap.xAxis = Axis(
                data = linspace(start = xMin.toFloat(), end = xMax.toFloat(), data.size)
            )
            /*Y axis*/
            heatmap.yAxis = Axis(
                data = linspace(start = yMin.toFloat(), end = yMax.toFloat(), data[0].size)
            )
            /*legend*/
            heatmap.visualMap = VisualMap(
                min,
                max,
                calculable = calculable,
                left = "0",
                bottom = "0",
                inRange = mapOf("color" to colorRange())
            )
            return heatmap
        }

        private fun remap(src: Array<Array<Float>>): Array<Array<Float>> {
            val dest = mutableListOf<Array<Float>>()
            for (i in src.indices) {
                for (j in src[0].indices) {
                    dest.add(arrayOf(i.toFloat(), j.toFloat(), src[i][j]))
                }
            }
            return dest.toTypedArray()
        }

        private fun colorRange(): Array<String> = arrayOf(
            "#313695", "#4575b4", "#74add1", "#abd9e9", "#e0f3f8",
            "#ffffbf", "#fee090", "#fdae61", "#f46d43", "#d73027",
            "#a50026"
        )
    }
}