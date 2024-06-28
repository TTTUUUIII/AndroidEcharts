package cn.touchair.androidecharts.common

import java.util.Locale

fun<T> T.linspace(start: Float, end: Float, count: Int): Array<Float> {
    val dest = FloatArray(count)
    val step = (end - start) / count;
    for (i in 0 until count) {
        dest[i] = String.format(Locale.US, "%.1f", start + i * step).toFloat()
    }
    return dest.toTypedArray()
}

fun<T> T.range(start: Int, end: Int): Array<Int> {
    val dest = IntArray(end - start)
    for (i in dest.indices) {
        dest[i] = i
    }
    return dest.toTypedArray()
}