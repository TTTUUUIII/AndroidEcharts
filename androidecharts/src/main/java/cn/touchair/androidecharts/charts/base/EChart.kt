package cn.touchair.androidecharts.charts.base
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Grid
import cn.touchair.androidecharts.widget.Title
import cn.touchair.androidecharts.widget.ToolTip
import com.google.gson.Gson

abstract class EChart(
    internal var xAxis: Axis<*>? = null,
    internal var yAxis: Axis<*>? = null,
    internal var grid: Grid? = null,
    internal var title: Title? = null,
    internal var tooltip: ToolTip? = null,
    internal var animation: Boolean = false,
    @Transient private val gson: Gson = Gson()
) {
    fun toJson(): String = gson.toJson(this)

    abstract class Builder {
        internal var xAxis: Axis<*>? = null
        internal var yAxis: Axis<*>? = null
        internal var grid: Grid? = null
        internal var title: Title? = null
        internal var tooltip: ToolTip? = null
        fun xAxis(axis: Axis<*>): Builder {
            xAxis = axis
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

        abstract fun build(): EChart
    }
}