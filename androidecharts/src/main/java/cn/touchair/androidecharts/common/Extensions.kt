package cn.touchair.androidecharts.common

import java.util.Locale

internal fun<T> T.linspace(start: Float, end: Float, count: Int): FloatArray {
    val dest = FloatArray(count)
    val step = (end - start) / count;
    for (i in 0 until count) {
        dest[i] = String.format(Locale.US, "%.1f", start + i * step).toFloat()
    }
    return dest
}

internal fun<T> T.range(start: Int, end: Int): IntArray {
    val dest = IntArray(end - start)
    for (i in dest.indices) {
        dest[i] = i
    }
    return dest
}