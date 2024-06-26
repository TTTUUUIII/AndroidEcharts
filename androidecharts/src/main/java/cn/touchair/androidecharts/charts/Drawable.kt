package cn.touchair.androidecharts.charts
import com.google.gson.Gson

abstract class Drawable(
    @Transient private val gson: Gson = Gson()
) {
    fun toJson(): String = gson.toJson(this)
}