package cn.touchair.androidecharts.interfaces

import androidx.annotation.IntDef

@IntDef(
    AxisType.X,
    AxisType.Y,
    AxisType.Z
)
annotation class AxisType {
    companion object {
        const val X = 1
        const val Y = 2
        const val Z = 3
    }
}