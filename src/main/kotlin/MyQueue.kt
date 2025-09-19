class MyQueue<T> {
    //реализация очереди с принципом FIFO (первый пришел - первый вышел)
    private val list = mutableListOf<T>()

    fun enqueue(item: T) {
        list.add(item)
    }

    fun dequeue(): T? {
        return if (list.isNotEmpty()) list.removeFirst() else null
    }

    fun peek(): T? {
        return list.firstOrNull()
    }

    fun isEmpty(): Boolean {
        return list.isEmpty()
    }

    override fun toString(): String {
        return list.toString()
    }
}