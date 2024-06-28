package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.BaseChart
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series
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