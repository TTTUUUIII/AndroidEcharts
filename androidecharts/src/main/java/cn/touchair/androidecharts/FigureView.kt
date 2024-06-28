package cn.touchair.androidecharts

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.core.view.isVisible
import cn.touchair.androidecharts.charts.base.EChart
@SuppressLint("SetJavaScriptEnabled")
class FigureView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private var notGrid = true
    private val engine: WebView = WebView(context)
    private val inProgressView: View = LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false)
    private var delayedChart: EChart? = null
    private var grid: Grid = Grid(1, 1)
    private var cursor: Cursor = Cursor(0, 0)

    init {
        engine.layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                inProgressView.visibility = GONE
                delayedChart?.let {
                    draw(it)
                }
            }
        }
        engine.webViewClient = webViewClient
        engine.settings.javaScriptEnabled = true
        engine.settings.allowFileAccess = true
        addView(engine)
        addView(inProgressView)
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        engine.loadUrl("file:///android_asset/h5/index.html")
    }

    fun draw(chart: EChart, cursor: Cursor = this.cursor, merge: Boolean = true) {
        if (isLoaded()) {
            if (notGrid) {
                grid()
            }
            engine.evaluateJavascript("draw(${cursor.x}, ${cursor.y}, ${chart.toJson()}, $merge)", null)
            delayedChart = null
        } else {
            delayedChart = chart
        }
        this.cursor = cursor
    }

    fun grid(grid: Grid = this.grid){
        if (isLoaded()) {
            engine.evaluateJavascript("grid(${grid.row}, ${grid.col})", null)
            notGrid = false
        }
        if (this.grid != grid) {
            this.grid = grid
        }
    }

    private fun isLoaded(): Boolean = !inProgressView.isVisible

    data class Grid(
        val row: Int,
        val col: Int
    )

    data class Cursor(
        val x: Int,
        val y: Int
    )
}

