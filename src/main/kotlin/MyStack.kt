class MyStack<T> {
    //реализация стека с принципом LIFO (последний пришел - первый вышел)
    private val list = mutableListOf<T>()

    fun to_stack(item: T) {
        list.add(item)
    }

    fun from_stack(): T? {
        return if (list.isNotEmpty()) list.removeLast() else null
    }
    override fun toString(): String {
        return list.toString()
    }
}