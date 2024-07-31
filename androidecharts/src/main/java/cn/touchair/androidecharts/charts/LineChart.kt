package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.BaseChart
import cn.touchair.androidecharts.annotations.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series

@Deprecated(
    "Since these chart options have no scalability, I recommend just creating the chart options by implement cn.touchair.androidecharts.interfaces.EChartOption."
)
/**
 * @see <a href="https://echarts.apache.org/examples/en/editor.html?c=line-simple">echart-line-simple</a>
 * @param T Number
 * @param data Array<T>
 * @constructor
 */
open class LineChart<T: Number> internal constructor(data: Array<T>): BaseChart() {
    val series: Series<Array<T>> = Series<Array<T>>(
        data = data,
        type = SeriesType.LINE,
        emphasis = Emphasis()
    )
    open class Builder<T: Number>(
        private var data: Array<T>,
    ): BaseChart.Builder() {

        override fun build(): LineChart<T> {
            val chart = LineChart(data)
            if (xAxis == null) {
                xAxis = Axis<Any>(
                    type = Axis.TYPE_VALUE
                )
            }
            if (yAxis == null) {
                yAxis = Axis<Any>(
                    type = Axis.TYPE_VALUE
                )
            }
            apply(chart)
            return chart
        }
    }
}