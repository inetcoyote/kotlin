import kotlin.math.round
fun main() {
    //queueworking()
    //stackworking()
    //oop()
    //math()
    //val in2 = readLine()!!.toInt()
    //callStudents()
    //callCircle()
    //callLogger()
    //callTriangle()
    //callcarinfo()
    //callNasledovanie
    //callNasledovanie2()
    //callNasledovanie3()
    //callNasledovanie4()
    //callAccessLevel()
    //callAccessLevel2()
    callAccessLevel3()

//test()

    }
object Logger {
    fun log(message: String) {
        println("Log: $message")
    }
}

fun callAccessLevel3() {
    val in1 = readLine()!!.toInt()
    var lista = mutableListOf<String>()

    for (i in 0..in1 - 1) {
        val instr = readLine()
        lista.add(instr!!.split(" ")[0])
    }

    for (i in 0..in1 - 1) {

        val teacher = Teacher()
        teacher.setSubject(lista[i].toString())
        teacher.printSubject()
    }
}

fun callAccessLevel2() {
    val in1 = readLine()!!.toInt()
    var lista = mutableListOf<String>()
    var listb = mutableListOf<String>()
    for (i in 0..in1 - 1) {
        val instr = readLine()
        lista.add(instr!!.split(" ")[0])
        listb.add(instr!!.split(" ")[1])
    }

    for (i in 0..in1 - 1) {

        val student = Student2()
        student.setName(lista[i].toString())
        student.setStudentId(listb[i].toInt())
        student.printStudentDetails()
    }
}

fun callAccessLevel() {
    val incount = readLine()!!.toInt()
    val list = mutableListOf<String>()
    for (i in 0..incount - 1) {
        list.add(readLine()!!.toString())
    }

    for (i in 0..incount - 1) {
        val person = Person2()
        person.setName(list[i])
        person.printName()
    }

}


fun callNasledovanie4() {
    //val in1 = readLine()!!.toInt()
    var listname = String()
    var listrole = String()
        val instr = readLine()
    listname = instr!!.split(" ")[0]
    listrole = instr!!.split(" ")[1]

    val user: Person = when (listrole.toString()) {
        "Moderator" -> Moderator(listname.toString())
        "Admin" -> Admin(listname.toString())
        else -> {
            println("Неизвестная роль.")
            return
        }
    }

    user.showInfo()

}

fun callNasledovanie3(){
    val in1 = readLine()!!.toString()
    if (in1 == "Car") {
        val car = Car2()
        car.drive()
    }
    else if (in1 == "Bicycle") {
        val bicycle = Bicycle()
        bicycle.drive()
    }
    else if (in1 == "Boat") {
        val boat = Boat()
        boat.drive()
    }
    else {
        println("Неверный ввод")
    }
}
fun callNasledovanie2(){
    val in1 = readLine()!!.toString()
    if (in1 == "Circle") {
        val cat = Circle2()
        cat.draw()
    }
    else if (in1 == "Square") {
        val square = Square()
        square.draw()
    }
    else if (in1 == "Triangle") {
        val triangle = Triangle2()
        triangle.draw()
    }
    else {
        println("Неверный ввод")
    }
}

fun callNasledovanie() {
    val in1 = readLine()!!.toString()
    if (in1 == "Cat") {
        val cat = Cat()
        cat.sound()
    }
    else if (in1 == "Dog") {
        val dog = Dog()
        dog.sound()
    }
    else if (in1 == "Bird") {
        val bird = Bird()
        bird.sound()
    }
    else {
        println("Неверный ввод")
    }
}
fun callcarinfo() {
    val in1 = readLine()!!.toInt()
    var lista = mutableListOf<String>()
    var listb = mutableListOf<String>()
    for (i in 0..in1 - 1) {
        val instr = readLine()
        lista.add(instr!!.split(" ")[0])
        listb.add(instr.split(" ")[1])
    }

    for (i in 0..in1 - 1) {
        val carinfo = Car(lista[i].toString(), listb[i].toInt(),)
        carinfo.printDetails()
    }
}
fun callTriangle() {
    val in1 = readLine()!!.toInt()
    var lista = mutableListOf<String>()
    var listb = mutableListOf<String>()
    var listc = mutableListOf<String>()
    for (i in 0..in1 - 1) {
        val instr = readLine()
        lista.add(instr!!.split(" ")[0])
        listb.add(instr.split(" ")[1])
        listc.add(instr.split(" ")[2])
    }

    for (i in 0..in1 - 1) {
        val ugol = Triangle(lista[i].toDouble(), listb[i].toDouble(), listc[i].toDouble())
        println(ugol.isEquilateral())
    }

}


fun callLogger() {
    val in1 = readln().toInt()
    val list = mutableListOf<String>()
    for (i in 0..in1 - 1) {
        list.add(readln())
    }
    for (i in 0..in1 - 1)
        Logger.log(list[i])

}

fun callStudents() {
    val in1 = readln().toInt()
    val listName = mutableListOf<String>()
    val listAge = mutableListOf<String>()
    for (i in 0..in1 - 1) {
        val instr = readln()
        listName.add(instr.split(" ")[0])
        listAge.add(instr.split(" ")[1])
    }

    for (i in 0 .. in1 - 1) {
        val student = Student(listName[i], listAge[i].toInt())
        student.printInfo()
    }
    //val student = Student("John", 20)
    //student.printInfo()

}
fun callCircle() {
    val in1 = readln().toDouble()
    var ar = Circle(in1, 0.0)
    ar.calculateArea()
    println("Radius: $in1")
    println("Area: ${ar.area}")
    //println("Area: ${round(ar.area)}")

//окончание функции
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




