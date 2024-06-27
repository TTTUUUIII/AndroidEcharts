package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.EChart
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series

class BarChart<T: Number>(data: Array<T>): EChart() {

    val series: Series<Array<T>>  = Series(
        data = data,
        type = SeriesType.BAR,
        emphasis = Emphasis()
    )
    class Builder<T: Number>(
        private var data: Array<T>
    ): EChart.Builder() {
        override fun build(): BarChart<T> {
            val chart = BarChart(data = data)
            chart.xAxis = xAxis
            chart.yAxis = yAxis
            chart.title = title
            chart.tooltip = tooltip
            return chart;
        }
    }
}