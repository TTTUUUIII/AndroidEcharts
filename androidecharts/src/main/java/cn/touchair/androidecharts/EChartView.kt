package cn.touchair.androidecharts

import android.annotation.SuppressLint
import android.content.Context
import android.util.AttributeSet
import android.webkit.WebView
import android.webkit.WebViewClient
import cn.touchair.androidecharts.charts.Drawable

@SuppressLint("SetJavaScriptEnabled")
class EChartView(context: Context, attrs: AttributeSet? = null) : WebView(context, attrs) {

    private var delayedDrawable: Drawable? = null
    private var loaded = false

    init {
        webViewClient = object: WebViewClient() {
            override fun onPageFinished(view: WebView?, url: String?) {
                super.onPageFinished(view, url)
                loaded = true
                delayedDrawable?.let {
                    draw(it, true)
                }
            }
        }
        settings.javaScriptEnabled = true
        settings.allowFileAccess = true
    }

    override fun onAttachedToWindow() {
        super.onAttachedToWindow()
        loadUrl("file:///android_asset/h5/index.html")
    }

    fun draw(drawable: Drawable, delayed: Boolean = false) {
        if (loaded) {
            evaluateJavascript("draw(${drawable.toJson()})", null)
            if (delayed) {
                delayedDrawable = null
            }
        } else {
            delayedDrawable = drawable
        }
    }
}