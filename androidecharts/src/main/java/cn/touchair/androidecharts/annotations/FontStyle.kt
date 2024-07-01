package cn.touchair.androidecharts.annotations

import androidx.annotation.StringDef

@StringDef(
    FontStyle.NORMAL,
    FontStyle.ITALIC,
    FontStyle.OBLIQUE
)
annotation class FontStyle {
    companion object {
        internal const val NORMAL = "normal"
        internal const val ITALIC = "italic"
        internal const val OBLIQUE = "oblique"
    }
}
