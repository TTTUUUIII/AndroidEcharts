package cn.touchair.androidecharts

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.touchair.androidecharts.charts.BaseChart

@SuppressLint("SetJavaScriptEnabled")
class EChartView(context: Context, attrs: AttributeSet? = null) : WebView(context, attrs) {
    init {
        webViewClient = WebViewClient()
        settings.javaScriptEnabled = true
        settings.allowFileAccess = true
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        loadUrl("file:///android_asset/h5/index.html")
    }

    fun<T: BaseChart> draw(chart: T) {
        evaluateJavascript("draw(${chart.toJson()})", null)
    }
}