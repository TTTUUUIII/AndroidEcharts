package cn.touchair.androidecharts

import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Bitmap
import android.util.AttributeSet
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebView
import android.webkit.WebViewClient
import android.widget.FrameLayout
import androidx.core.view.isVisible
import cn.touchair.androidecharts.interfaces.EChartOption

@SuppressLint("SetJavaScriptEnabled")
class FigureView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private var loaded = false
    private val engine: WebView = WebView(context)
    private val inProgressView: View = LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false)
    private var cache: EChartOption? = null
    private var grid: Grid = Grid(1, 1)

    init {
        engine.layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val webViewClient = object: WebViewClient() {
            override fun onPageStarted(view: WebView?, url: String?, favicon: Bitmap?) {
                super.onPageStarted(view, url, favicon)
                inProgressView.visibility = VISIBLE
            }

            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                inProgressView.visibility = GONE
                loaded = true
                grid(grid)
                cache?.let { draw(it, false) }
            }
        }
        engine.webViewClient = webViewClient
        engine.settings.javaScriptEnabled = true
        engine.settings.allowFileAccess = true
        addView(engine)
        addView(inProgressView)
        reload()
    }

    fun draw(chart: EChartOption, merge: Boolean = true) = draw(chart, gx = 0, gy = 0, merge = merge)
    private fun draw(chart: EChartOption, gx: Int, gy: Int, merge: Boolean = true) {
        if (isLoaded()) {
            engine.evaluateJavascript("draw(${gx}, ${gy}, ${chart.asOption()}, $merge);", null)
        }
        cache = chart
    }

    override fun setVisibility(visibility: Int) {
        if (visibility == this.visibility) return
        super.setVisibility(visibility)
        if (isVisible) {
            reload()
        }
    }

    private fun grid(grid: Grid){
        if (isLoaded()) {
            engine.evaluateJavascript("grid(${grid.row}, ${grid.col});", null)
        }
        this.grid = grid
    }

    private fun clear() {
        if (isLoaded()) {
            engine.evaluateJavascript("clear();", null)
        }
    }

    private fun reload() {
        loaded = false
        engine.loadUrl("file:///android_asset/h5/index.html")
    }

    private fun isLoaded(): Boolean = loaded

    data class Grid(
        val row: Int,
        val col: Int
    )

    private inner class DelayedChart(
        val chart: EChartOption,
        val gx: Int,
        val gy: Int
    )
}

