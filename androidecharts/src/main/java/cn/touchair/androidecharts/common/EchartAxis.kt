package cn.touchair.androidecharts.common

data class EchartAxis<T>(
    val data: Array<T>,
    val type: String = "category"
) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as EchartAxis<*>

        if (!data.contentEquals(other.data)) return false
        if (type != other.type) return false

        return true
    }

    override fun hashCode(): Int {
        var result = data.contentHashCode()
        result = 31 * result + type.hashCode()
        return result
    }
}