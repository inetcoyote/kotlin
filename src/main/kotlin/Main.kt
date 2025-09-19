import kotlin.math.round
fun main() {
    //queueworking()
    stackworking()
    //oop()
    //math()
}

fun stackworking() {
    val stack = MyStack<Int>()
    stack.to_stack(1)
    stack.to_stack(2)
    stack.to_stack(3)
    println("Стек из чисел")
    println("Перечень значений в стека: $stack")
    stack.from_stack()
    println("Исключили из стека: $stack")
    stack.to_stack(4)
    println("Добавили новое значение в стек: $stack")
    println("========================")
    println("Стек из строк")
    val stackstr = MyStack<String>()
    stackstr.to_stack("Петя")
    stackstr.to_stack("Вася")
    stackstr.to_stack("Федя")
    println("Перечень значений в стеке: $stackstr")
    stackstr.from_stack()
    println("Исключили из стека: $stackstr")
    stackstr.to_stack("Евгений Павлович")
    println("Добавили новое значение в стек: $stackstr")
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
    val mac = Notebook ("Apple", "MacBook")
    val phone = Phone ("HONOR", "HONOR 100")

    val portables = listOf(phone, mac)
    portables.forEach { it.work() }

    val allDevice = listOf(hp, mac, phone)
    allDevice.forEach { it.deviceInfo() }

/*
    //скойп функция для проверки работы ноутбука - не нужно в каждой строчке писать mac ни this
    with (phone) {
        batteryInfo()
        work()
        work()
        batteryInfo()
        charge()
        batteryInfo()
    }
    */

    //val computers = listOf(hp, mac)
    //computers.forEach { it.installDocker() }

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




