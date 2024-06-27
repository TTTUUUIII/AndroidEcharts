package cn.touchair.androidecharts

import android.os.Bundle
import android.view.View
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.touchair.androidecharts.charts.AreaChart
import cn.touchair.androidecharts.charts.BarChart
import cn.touchair.androidecharts.charts.LineChart
import cn.touchair.androidecharts.charts.HeatmapChart
import cn.touchair.androidecharts.charts.PieChart
import cn.touchair.androidecharts.databinding.ActivityMainBinding
import cn.touchair.androidecharts.widget.Axis
import cn.touchair.androidecharts.widget.Grid
import cn.touchair.androidecharts.widget.Title
import cn.touchair.androidecharts.widget.ToolTip
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }
    private val gson: Gson = Gson()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        drawLineChart()
        bindEvent()
    }

    private fun bindEvent() {
        binding.buttonHeatmap.setOnClickListener(this::onAction)
        binding.buttonArea.setOnClickListener(this::onAction)
        binding.buttonLine.setOnClickListener(this::onAction)
        binding.buttonBar.setOnClickListener(this::onAction)
        binding.buttonPie.setOnClickListener(this::onAction)
    }

    private fun onAction(view: View) {
        when (view.id) {
            R.id.button_heatmap -> drawHeatmapChart()
            R.id.button_area -> drawAreaChart()
            R.id.button_line -> drawLineChart()
            R.id.button_bar -> drawBarChart()
            R.id.button_pie ->drawPieChart()
            else -> {}
        }
    }

    private fun drawLineChart() {
        val data = arrayOf(820, 932, 901, 934, 1290, 1330, 1320)
        val area = LineChart.Builder(data = data)
            .xAxis(
                Axis(
                    data = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                )
            )
            .yAxis(
                Axis<Any>(type = "value")
            )
            .build()
        binding.chartView.draw(area, merge = false)
    }

    private fun drawAreaChart() {
        val data = arrayOf(820, 932, 901, 934, 1290, 1330, 1320)
        val area = AreaChart.Builder(data = data)
            .xAxis(
                Axis(
                    data = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                )
            )
            .yAxis(
                Axis<Any>(type = "value")
            )
            .title(
                Title("Area", left = "center", top = "10")
            )
            .build()
        binding.chartView.draw(area, merge = false)
    }

    private fun drawPieChart() {
        val data = arrayOf<Map<String, Any>>(
            mapOf(
                "value" to 1048,
                "name" to "Search Engine"
            ),
            mapOf(
                "value" to 735,
                "name" to "Direct"
            ),
            mapOf(
                "value" to 580,
                "name" to "Email"
            ),
            mapOf(
                "value" to 484,
                "name" to "Union Ads"
            ),
            mapOf(
                "value" to 300,
                "name" to "Video Ads"
            )
        )

        val pie = PieChart.Builder(data = data)
            .tooltip(
                ToolTip(
                    trigger = ToolTip.TRIGGER_ITEM
                )
            )
            .title(
                Title(
                    "Referer of a Website",
                    left = "center",
                    top = "10"
                )
            )
            .build()
        binding.chartView.draw(pie, merge = false)
    }

    private fun drawBarChart() {
        val data = arrayOf(120, 200, 150, 80, 70, 110, 130)
        val bar = BarChart.Builder(data = data)
            .xAxis(
                Axis(
                    data = arrayOf("Mon", "Tue", "Wed", "Thu", "Fri", "Sat", "Sun")
                )
            )
            .yAxis(
                Axis<Any>(type = "value")
            )
            .tooltip(
                ToolTip(trigger = ToolTip.TRIGGER_ITEM)
            )
            .build()
        binding.chartView.draw(bar, merge = false)
    }

    private fun drawHeatmapChart() {
        assets.open("data/heatmap.json")
            .use {
                val text = it.readBytes().toString(Charsets.UTF_8)
                val data: Array<Array<Float>> =
                    gson.fromJson(text, object : TypeToken<Array<Array<Float>>>() {}.type)
                val heatmap = HeatmapChart.Builder(data)
                    .title(
                        Title("Heatmap", left = "center", top = "10")
                    )
                    .grid(
                        Grid(bottom = "70", show = true)
                    )
                    .build()
                binding.chartView.draw(heatmap, merge = false)
            }
    }
}