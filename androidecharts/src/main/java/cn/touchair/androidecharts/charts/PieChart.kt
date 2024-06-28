package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.charts.base.EChart
import cn.touchair.androidecharts.interfaces.Orient
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Legend
import cn.touchair.androidecharts.widget.Series

class PieChart(
    data: Array<Map<String, Any>>,
    val legend: Legend? = null
): EChart() {
    val series: Series<Array<Map<String, Any>>> = Series(
        data =  data,
        type = SeriesType.PIE,
        radius = "50%"
    )

    class Builder(
        private var data: Array<Map<String, Any>>
    ): EChart.Builder() {
        private var legend: Legend = Legend(
            orient = Orient.VERTICAL,
            top = "8%"
        )
        fun legend(legend: Legend): Builder {
            this.legend = legend
            return this
        }

        override fun build(): EChart {
            val chart = PieChart(data = data, legend = legend)
            apply(chart)
            return chart
        }
    }
}