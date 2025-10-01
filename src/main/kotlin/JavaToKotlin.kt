class JavaCode {
    fun toJSON(collection: Collection<Int?>): String {
        val sb = StringBuilder()
        sb.append("[")
        val iterator = collection.iterator()
        while (iterator.hasNext()) {
            val element = iterator.next()
            sb.append(element)
            if (iterator.hasNext()) {
                sb.append(", ")
            }
        }
        sb.append("]")
        return sb.toString()
    }
}

fun joinToString(separator: String = ", ", prefix: String = "[", postfix: String = "]" , collection: Collection<String?>): String {
    return collection.joinToString(separator, prefix, postfix)
    //return TODO("Provide the return value")
}

fun main(args: Array<String>) {
    println(joinToString(", " , "[" , "]" , listOf("1", "2", "3")))
}