package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.BaseChart
import cn.touchair.androidecharts.annotations.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series
import cn.touchair.androidecharts.widget.VisualMap
import kotlin.math.ceil
import kotlin.math.floor

@Deprecated(
    "Since these chart options have no scalability, I recommend just creating the chart options by implement cn.touchair.androidecharts.interfaces.EChartOption."
)
/**
 * @see <a href="https://echarts.apache.org/examples/en/editor.html?c=heatmap-large">echart-heatmap</a>
 * @param T Number
 * @param data Array<T>
 * @constructor
 */
class HeatmapChart private constructor(
    data: Array<Array<Float>>,
    private var visualMap: VisualMap
) : BaseChart() {

    val series: Series<Array<Array<Float>>> = Series(
        SeriesType.HEATMAP,
        data,
        emphasis = Emphasis(),
        progressive = 1000,
        animation = false
    )

    class Builder(
        private var data: Array<Array<Float>>,
        private val min: Any = 0F,
        private val max: Any = 0F,
        private val remap: Boolean = true
    ) : BaseChart.Builder() {

        private var visualMap: VisualMap = VisualMap(
            min = vmin(),
            max = vmax(),
            calculable = min is Number && max is Number,
            left = "0",
            bottom = "0",
            inRange = mapOf(
                "color" to colorRange()
            )
        )

        private fun vmax(): Any = if (min == max) ceil(data.maxOf { it.max() }) else max
        private fun vmin(): Any = if (min==max) floor(data.minOf { it.min() }) else min

        override fun build(): HeatmapChart {
            val chart = HeatmapChart(
                data = if (remap) remap(data) else data,
                visualMap = visualMap
            )
            if (xAxis == null) {
                xAxis = Axis<Any>(
                    type = Axis.TYPE_CATEGORY
                )
            }
            if (yAxis == null) {
                yAxis = Axis<Any>(
                    type = Axis.TYPE_CATEGORY
                )
            }
            apply(chart)
            return chart
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