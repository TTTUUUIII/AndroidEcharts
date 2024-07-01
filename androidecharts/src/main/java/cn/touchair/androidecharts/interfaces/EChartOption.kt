package cn.touchair.androidecharts.interfaces

import com.google.gson.Gson

interface EChartOption {
    fun asOption(): String = gson.toJson(this)

    companion object {
        private val gson = Gson()
    }
}