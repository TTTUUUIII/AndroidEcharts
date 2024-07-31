package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.BaseChart
import cn.touchair.androidecharts.annotations.SeriesType
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Legend
import cn.touchair.androidecharts.widget.Series

@Deprecated(
    "Since these chart options have no scalability, I recommend just creating the chart options by implement cn.touchair.androidecharts.interfaces.EChartOption."
)
/**
 * @see cn.touchair.androidecharts.interfaces.EChartOption
 * @see <a href="https://echarts.apache.org/examples/en/editor.html?c=pie-simple">echart-pie-simple</a>
 * @param data Array<Map<String, Any>>
 * @param legend Legend?
 * @constructor
 */
class PieChart(
    data: Array<Map<String, Any>>,
    val legend: Legend? = null
): BaseChart() {
    val series: Series<Array<Map<String, Any>>> = Series(
        data =  data,
        type = SeriesType.PIE,
        radius = "50%",
        emphasis = Emphasis()
    )

    class Builder(
        private var data: Array<Map<String, Any>>,
    ): BaseChart.Builder() {
        private var legend: Legend? = null
        fun legend(legend: Legend): Builder {
            this.legend = legend
            return this
        }

        override fun build(): BaseChart {
            val chart = PieChart(data = data, legend = legend)
            apply(chart)
            return chart
        }
    }
}