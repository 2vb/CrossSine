package net.ccbluex.liquidbounce.features.value

import com.google.gson.JsonElement
import com.google.gson.JsonPrimitive
import java.util.*

/**
 * List value represents a selectable list of values
 */
open class ListValue(name: String, val values: Array<String>, value: String) : Value<String>(name, value) {
    @JvmField
    var openList = false
    fun getModeListNumber(mode: String) = values.indexOf(mode)
    init {
        this.value = value
    }

    fun containsValue(string: String): Boolean {
        return Arrays.stream(values).anyMatch { it.equals(string, ignoreCase = true) }
    }

    override fun changeValue(value: String) {
        for (element in values) {
            if (element.equals(value, ignoreCase = true)) {
                this.value = element
                break
            }
        }
    }
    fun nextValue() {
        var index = values.indexOf(value) + 1
        if (index > values.size - 1) index = 0
        value = values[index]
    }
     fun getModes(): List<String?>? {
         return values.toList()
    }
    open fun getModeGet(i: Int): String? {
        return values[i]
    }
    override fun toJson() = JsonPrimitive(value)

    override fun fromJson(element: JsonElement) {
        if (element.isJsonPrimitive) changeValue(element.asString)
    }
}


