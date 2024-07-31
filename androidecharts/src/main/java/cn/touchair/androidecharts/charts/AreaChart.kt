package cn.touchair.androidecharts.charts

@Deprecated(
    "Since these chart options have no scalability, I recommend just creating the chart options by implement cn.touchair.androidecharts.interfaces.EChartOption."
)
/**
 * @see <a href="https://echarts.apache.org/examples/en/editor.html?c=area-basic">echart-area-basic</a>
 * @param T Number
 * @param data Array<T>
 * @constructor
 */
class AreaChart<T: Number>(data: Array<T>): LineChart<T>(data) {
    class Builder<T: Number>(
        data: Array<T>,
    ): LineChart.Builder<T>(data) {
        override fun build(): LineChart<T> {
            val chart = super.build()
            chart.xAxis?.boundaryGap = false
            chart.series.areaStyle = mapOf<String, Any>()
            return chart
        }
    }
}