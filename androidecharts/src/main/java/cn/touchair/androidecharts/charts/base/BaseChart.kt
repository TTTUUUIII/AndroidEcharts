package cn.touchair.androidecharts.charts.base
import cn.touchair.androidecharts.annotations.AxisType
import cn.touchair.androidecharts.interfaces.EChartOption
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Grid
import cn.touchair.androidecharts.widget.Title
import cn.touchair.androidecharts.widget.ToolTip
import com.google.gson.Gson

abstract class BaseChart(
    internal var xAxis: Axis<*>? = null,
    internal var yAxis: Axis<*>? = null,
    internal var grid: Grid? = null,
    internal var title: Title? = null,
    internal var tooltip: ToolTip? = null,
    internal var animation: Boolean = false,
    @Transient private val gson: Gson = Gson()
): EChartOption {

    abstract class Builder {
        internal var xAxis: Axis<*>? = null
        internal var yAxis: Axis<*>? = null
        private var grid: Grid? = null
        private var title: Title? = null
        private var tooltip: ToolTip? = null
        fun axis(@AxisType type: Int, axis: Axis<*>): Builder {
            when(type) {
                AxisType.X -> xAxis = axis
                AxisType.Y -> yAxis = axis
                else -> {

                }
            }
            return this
        }

        fun yAxis(axis: Axis<*>): Builder {
            yAxis = axis
            return this
        }

        fun grid(grid: Grid): Builder {
            this.grid = grid
            return this
        }

        fun tooltip(tooltip: ToolTip): Builder {
            this.tooltip = tooltip
            return this
        }

        fun title(title: Title): Builder {
            this.title = title
            return this
        }

        internal fun apply(chart: BaseChart) {
            chart.xAxis = xAxis
            chart.yAxis = yAxis
            chart.tooltip = tooltip
            chart.title = title
            chart.grid = grid
        }

        abstract fun build(): BaseChart
    }
}