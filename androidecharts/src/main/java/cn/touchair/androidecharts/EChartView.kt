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
class EChartView(context: Context, attrs: AttributeSet? = null) : FrameLayout(context, attrs) {

    private val engine: WebView = WebView(context)
    private val inProgressView: View = LayoutInflater.from(context).inflate(R.layout.layout_loading, this, false)
    private var delayedDrawable: EChart? = null

    init {
        engine.layoutParams = LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT)
        val webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                inProgressView.visibility = GONE
                delayedDrawable?.let {
                    draw(it, true)
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

    fun draw(drawable: EChart, notMerge: Boolean = false, delayed: Boolean = false) {
        if (isLoaded()) {
            engine.evaluateJavascript("draw(${drawable.toJson()}, $notMerge)", null)
            if (delayed) {
                delayedDrawable = null
            }
        } else {
            delayedDrawable = drawable
        }
    }

    private fun isLoaded(): Boolean = !inProgressView.isVisible
}