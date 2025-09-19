fun main() {
    queueworking()
    //oop()

}

fun queueworking() {
    val queue = MyQueue<Int>()
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    println("Очередь из чисел")
    println("Перечень значений в очереди: $queue")
    queue.dequeue()
    println("Исключили из очереди: $queue")
    queue.enqueue(4)
    println("Добавили новое значение в очередь: $queue")
    println("========================")
    println("Очередь из строк")
    val queuestr = MyQueue<String>()
    queuestr.enqueue ("Петя")
    queuestr.enqueue("Вася")
    queuestr.enqueue("Федя")
    println("Перечень значений в очереди: $queuestr")
    queuestr.dequeue()
    println("Исключили из очереди: $queuestr")
    queuestr.enqueue("Евгений Павлович")
    println("Добавили новое значение в очередь: $queuestr")
}

fun oop(){
    val hp = PC ("HP", "HP Pro")
    hp.installDocker()



}

fun math(){

    val res = MyFunctions().Add(21, 2)
    println(res)

    val res2 = MyFunctions().minus(2, 22)
    println(res2)

    println("Введите число 1")
    var myin1 = readLine()
    val intNumber1 = myin1!!.toInt()
    println("Введите число 2")
    var myin2 = readLine()
    val intNumber2 = myin2!!.toInt()

    val res3 = MyFunctions().delete(intNumber1, intNumber2)
    println("Результат от деления = ")
    println(res3)
}




