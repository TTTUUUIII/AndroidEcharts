package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.BaseChart
import cn.touchair.androidecharts.annotations.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series

class BarChart<T: Number>(data: Array<T>): BaseChart() {

    val series: Series<Array<T>>  = Series(
        data = data,
        type = SeriesType.BAR,
        emphasis = Emphasis()
    )
    class Builder<T: Number>(
        private var data: Array<T>
    ): BaseChart.Builder() {
        override fun build(): BarChart<T> {
            val chart = BarChart(data = data)
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
            return chart;
        }
    }
}