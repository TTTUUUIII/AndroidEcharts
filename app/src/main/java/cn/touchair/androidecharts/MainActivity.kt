package cn.touchair.androidecharts

import android.os.Bundle
import android.os.SystemClock
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.util.toRange
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import cn.touchair.androidecharts.charts.HeatMapChart
import cn.touchair.androidecharts.databinding.ActivityMainBinding
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
        val intRange = IntRange(0, 10)
        val random = Random(SystemClock.uptimeMillis())
        val heatMapChart = HeatMapChart(
            0f,
            1f,
            arrayOf(
                arrayOf(random.nextFloat(),random.nextFloat(),random.nextFloat(),random.nextFloat()),
                arrayOf(random.nextFloat(),random.nextFloat(),random.nextFloat(),random.nextFloat()),
                arrayOf(random.nextFloat(),random.nextFloat(),random.nextFloat(),random.nextFloat()),
            )
        )
        binding.chartView.draw(heatMapChart)
    }
}