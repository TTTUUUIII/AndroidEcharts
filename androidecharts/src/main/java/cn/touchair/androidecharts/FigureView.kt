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
import cn.touchair.androidecharts.interfaces.EChart

@SuppressLint("SetJavaScriptEnabled")
class FigureView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private var loaded = false
    private val engine: WebView = WebView(context)
    private val inProgressView: View = LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false)
    private val waitList: MutableList<DelayedChart> by lazy { mutableListOf<DelayedChart>() }
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
                synchronized(this) {
                    waitList.forEach {
                        draw(it.chart,  it.gx, it.gy)
                    }
                    waitList.clear()
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

    override fun onDetachedFromWindow() {
        super.onDetachedFromWindow()
        clear()
    }

    fun draw(chart: EChart, merge: Boolean = true) = draw(chart, gx = 0, gy = 0, merge = merge)
    private fun draw(chart: EChart, gx: Int, gy: Int, merge: Boolean = true) {
        if (isLoaded()) {
            engine.evaluateJavascript("draw(${gx}, ${gy}, ${chart.asOption()}, $merge);", null)
        } else {
            synchronized(this) {
                waitList.add(
                    DelayedChart(
                        chart,
                        gx,
                        gy
                    )
                )
            }
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
        loaded = false
    }

    private fun isLoaded(): Boolean = loaded

    data class Grid(
        val row: Int,
        val col: Int
    )

    private inner class DelayedChart(
        val chart: EChart,
        val gx: Int,
        val gy: Int
    )
}

