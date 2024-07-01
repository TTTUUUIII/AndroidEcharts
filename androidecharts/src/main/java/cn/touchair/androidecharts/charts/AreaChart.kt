package cn.touchair.androidecharts.charts

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