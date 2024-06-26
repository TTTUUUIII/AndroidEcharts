package cn.touchair.androidecharts.common

import cn.touchair.androidecharts.charts.Drawable
import java.util.Locale

internal fun Drawable.linspace(start: Float, end: Float, count: Int): Array<Float> {
    val dest = FloatArray(count)
    val step = (end - start) / count;
    for (i in 0 until count) {
        dest[i] = String.format(Locale.US, "%.1f", start + i * step).toFloat()
    }
    return dest.toTypedArray()
}