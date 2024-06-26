package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.common.EchartAxis
import cn.touchair.androidecharts.common.EchartSeries

class HeatMapChart(
    min: Float,
    max: Float,
    data: Array<Array<Float>>
): BaseChart() {
//    val xAxis: EchartAxis<Int>
//    val yAxis: EchartAxis<Int>

    var visualMap: Map<String, Any> = mapOf(
        "min" to min,
        "max" to max,
        "calculable" to true,
        "realtime" to false,
        "inRange" to mapOf<String, Any>(
            "color" to colorRange()
        ),
    )
    val series: EchartSeries = EchartSeries(
        "Gaussian",
        "heatmap",
        data,
        emphasis = mapOf(
            "itemStyle" to mapOf<String, Any>(
                "borderColor" to "#333",
                "borderWidth" to 1
            )
        ),
        progressive = 1000,
        animation = false
    )
    
    private fun colorRange(): Array<String> = arrayOf(
        "#313695", "#4575b4", "#74add1", "#abd9e9", "#e0f3f8",
        "#ffffbf", "#fee090", "#fdae61", "#f46d43", "#d73027",
        "#a50026"
    )
}