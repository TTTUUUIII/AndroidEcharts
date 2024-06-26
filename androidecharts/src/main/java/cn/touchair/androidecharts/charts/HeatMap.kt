package cn.touchair.androidecharts.charts

import cn.touchair.androidecharts.common.Shape
import cn.touchair.androidecharts.common.linspace
import cn.touchair.androidecharts.interfaces.SeriesType
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.DataSeries

class HeatMap<T>(
    min: Float,
    max: Float,
    data: List<List<T>>,
    shape: Shape,
    xMin: Float = 0F,
    xMax: Float = 0F,
    yMin: Float = 0F,
    yMax: Float = 0F,
): Drawable() {
    val  xAxis: List<Axis<*>> = listOf(
        if (xMin < xMax) {
            Axis<Float>(linspace(xMin, xMax, shape.x))
        } else {
            Axis<Int>(
                IntArray(shape.x) { it + 1 }.toTypedArray()
            )
        }
    )
    val yAxis: List<Axis<Int>> = listOf(
        Axis<Int>(IntArray(shape.y) { it + 1 }.toTypedArray())
    )

    var visualMap: Map<String, Any> = mapOf(
        "min" to min,
        "max" to max,
        "calculable" to true,
        "realtime" to false,
        "inRange" to mapOf<String, Any>(
            "color" to colorRange()
        ),
    )
    val series: DataSeries<List<List<T>>> = DataSeries<List<List<T>>>(
        "Gaussian",
        SeriesType.HEATMAP,
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