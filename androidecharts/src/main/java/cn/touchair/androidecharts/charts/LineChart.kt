package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.EChart
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Emphasis
import cn.touchair.androidecharts.widget.Series
open class LineChart<T: Number> internal constructor(data: Array<T>): EChart() {
    val series: Series<Array<T>> = Series<Array<T>>(
        data = data,
        type = SeriesType.LINE,
        emphasis = Emphasis()
    )
    open class Builder<T: Number>(
        private var data: Array<T>,
    ): EChart.Builder() {
        override fun build(): LineChart<T> {
            val chart = LineChart(data)
            apply(chart)
            return chart
        }
    }
}