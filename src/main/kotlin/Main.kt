import kotlin.math.round
fun main() {
    //queueworking()
    //oop()
    math()
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

    val res = MyFunctions().plus(21, 2)
    println("Сумма чисел 21 и 2 равна $res")

    val res2 = MyFunctions().minus(2, 22)
    println("Разность чисел 2 и 22 равна $res2")

    println("Введите число 1:")
    var instr1 = readLine()
    val num1 = instr1!!.toDouble()
    println("Введите число 2:")
    var instr2 = readLine()
    val num2 = instr2!!.toDouble()

    val res3 = MyFunctions().delete(num1, num2)
    println("Результат от деления $num1 на $num2 равен $res3")
}




