package cn.touchair.androidecharts

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.touchair.androidecharts.charts.HeatMap
import cn.touchair.androidecharts.common.Shape
import cn.touchair.androidecharts.databinding.ActivityMainBinding
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.io.File
import java.util.Arrays
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
        val text = File("$externalCacheDir/data_heatmap.json")
            .readText()
        val data: List<List<Float>> = Gson().fromJson(text, object: TypeToken<List<List<Float>>>(){}.type)
        val remap = remap(data)
        println(remap)
        val heatMapChart = HeatMap<Float>(
            0.3f,
            1.4f,
            remap,
            Shape(data.size, data[0].size)
        )
        binding.chartView.draw(heatMapChart)
    }

    private fun remap(data: List<List<Float>>): List<List<Float>> {
        val newData = mutableListOf<List<Float>>()
        for (i in 0 until data.size) {
            for (j in 0 until data[0].size) {
                newData.add(listOf(i.toFloat(), j.toFloat(), data[i][j]))
            }
        }
        return newData
    }
}