import kotlin.math.PI

abstract class AbstractShape {
    abstract fun area() : Double
}

class AbstractCircle (private val radius: Double) : AbstractShape() {
    override fun area() : Double {
        return PI * radius * radius
    }
}
class AbstractRectangle(private val width: Double, private val height: Double) : AbstractShape() {
    override fun area() : Double
    {
        return width * height
    }
}



fun main() {
    //callAbstract1()
    //callAbstract2()
    callAbstract3()
}

fun callAbstract1() {
    val intype = readLine()!!.toString()
    val shape: AbstractShape = when (intype) {
        "circle" -> AbstractCircle(readLine()!!.toDouble())
        "rectangle" -> AbstractRectangle(readLine()!!.toDouble(), readLine()!!.toDouble())
        else -> throw IllegalArgumentException("Неверный тип фигуры")
    }
    val area = shape.area()
    println("Area: $area")
}

fun callAbstract2() {
    val intype = readLine()!!.toString()
    val person: PersonAbstract = when (intype) {
        "student" -> AbstractStudent(readLine()!!.toString(), readLine()!!.toInt())
        "teacher" -> AbstractTeacher(readLine()!!.toString(), readLine()!!.toString())
        else -> throw IllegalArgumentException("Неверный тип человека")
    }
    val info = person.info()
    println(info)
}


abstract class PersonAbstract {
    abstract fun info() : String
}

class AbstractStudent (private val name: String, private val age: Int) : PersonAbstract() {
    override fun info() : String {
        return "Student: $name, Age: $age"
    }
}

class AbstractTeacher (private val name: String, private val subject: String) : PersonAbstract() {
    override fun info() : String {
        return "Teacher: $name, Subject: $subject"
    }}

fun callAbstract3() {
    val intype = readLine()!!.toString()
    val shape: AbstractShape2 = when (intype) {
        "circle" -> AbstractCircle2()
        "square" -> AbstractSquare()
        else -> throw IllegalArgumentException("Неверный тип фигуры")
    }
    val draw = shape.draw()
    println(draw)
}

abstract class AbstractShape2 {
    abstract fun draw() : String
}

class AbstractCircle2() : AbstractShape2() {
    override fun draw() : String {
        return "Drawing a circle"
    }}

class AbstractSquare() : AbstractShape2() {
    override fun draw() : String {
        return "Drawing a square"
    }
}
