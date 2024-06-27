package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.style.AreaStyle

class AreaChart<T: Number>(data: Array<T>): LineChart<T>(data) {
    class Builder<T: Number>(
        data: Array<T>,
    ): LineChart.Builder<T>(data) {
        override fun build(): LineChart<T> {
            val chart = super.build()
            chart.xAxis?.boundaryGap = false
            chart.tooltip = tooltip
            chart.series.areaStyle = AreaStyle()
            return chart
        }
    }
}