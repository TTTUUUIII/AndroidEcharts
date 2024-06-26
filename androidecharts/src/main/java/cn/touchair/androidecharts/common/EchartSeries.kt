package cn.touchair.androidecharts.common

data class EchartSeries(
    val name: String,
    val type: String,
    val data: Array<Array<Float>>,
    val emphasis: Map<String, Any>? = null,
    val progressive: Int? = null,
    val animation: Boolean = false
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EchartSeries

        if (name != other.name) return false
        if (type != other.type) return false
        if (!data.contentDeepEquals(other.data)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = name.hashCode()
        result = 31 * result + type.hashCode()
        result = 31 * result + data.contentDeepHashCode()
        return result
    }
}