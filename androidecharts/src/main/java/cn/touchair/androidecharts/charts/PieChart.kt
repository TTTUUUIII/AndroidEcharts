package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.EChart
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Series

class PieChart(data: Array<Map<String, Any>>): EChart() {
    val series: Series<Array<Map<String, Any>>> = Series(
        data =  data,
        type = SeriesType.PIE,
        radius = "50%"
    )

    class Builder(
        private var data: Array<Map<String, Any>>
    ): EChart.Builder() {
        override fun build(): EChart {
            val chart = PieChart(data = data)
            apply(chart)
            return chart
        }
    }
}