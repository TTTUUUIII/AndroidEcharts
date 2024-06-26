package cn.touchair.androidecharts.charts
import com.google.gson.Gson

abstract class BaseChart(
    @Transient private val gson: Gson = Gson()
) {
    fun toJson(): String = gson.toJson(this)
}