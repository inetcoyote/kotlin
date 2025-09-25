class MathUtils {
    fun add(x: Int, y: Int): Int {
        return x + y
    }

    fun add(x: Double, y: Double): Double {
        return x + y
    }

}

class Calculator {
    fun calculate(x: Int, y: Int): Int {
        return x + y
    }
    fun calculate(x: Double, y: Double): Double {
        return x * y
    }
    fun calculate(x: String, y: String): String {
        return x + y
    }
}

class MathOperations {
    fun add(a: Int, b: Int): Double {
        return (a + b).toDouble()
    }
    fun add(a: Double, b: Double): Double {
        return a + b
    }
    fun subtract(a: Int, b: Int): Double {
        return (a - b).toDouble()
    }
    fun subtract(a: Double, b: Double): Double {
        return a - b
    }
    fun multiply(a: Int, b: Int): Double {
        return (a * b).toDouble()
    }
    fun multiply(a: Double, b: Double): Double {
        return a * b
    }
    fun divide(a: Int, b: Int): Double {
        return a.toDouble() / b
    }
    fun divide(a: Double, b: Double): Double {
        return a / b
    }
}


fun main() {
    val math = MathUtils()
    println(math.add(1, 2))     // Выводит 3
    println(math.add(1.5, 2.5)) // Выводит 4.0
    //callpolymorfism()
    //callpolymorfism2()


}

fun callpolymorfism() {
    val intype = readLine()!!.toString()
    val in1 = readLine()!!.toString()
    val in2 = readLine()!!.toString()
    if (intype == "add") {
        val calc = Calculator()
        println(calc.calculate(in1.toInt(), in2.toInt()))
    }
    else if (intype == "multiply") {
        val calc = Calculator()
        println(calc.calculate(in1.toDouble(), in2.toDouble()))
    }
    else if (intype == "concatenate") {
        val calc = Calculator()
        println(calc.calculate(in1, in2))
    }
}

fun callpolymorfism2() {
    val intype = readLine()!!.toString()
    val inoper = readLine()!!.toString()
    val in1 = readLine()!!.toString()
    val in2 = readLine()!!.toString()
    val math = MathOperations()
    if (intype == "Int") {
        if (inoper == "add") {
            println(math.add(in1.toInt(), in2.toInt()))
        }
        else if (inoper == "subtract") {
            println(math.subtract(in1.toInt(), in2.toInt()))
        }
        else if (inoper == "multiply") {
            println(math.multiply(in1.toInt(), in2.toInt()))
        }
        else if (inoper == "divide") {
            println(math.divide(in1.toInt(), in2.toInt()))
        }
    }
    else if (intype == "Double") {
        if (inoper == "add") {
            println(math.add(in1.toDouble(), in2.toDouble()))
        }
        else if (inoper == "subtract") {
            println(math.subtract(in1.toDouble(), in2.toDouble()))
        }
        else if (inoper == "multiply") {
            println(math.multiply(in1.toDouble(), in2.toDouble()))
        }
        else if (inoper == "divide") {
            println(math.divide(in1.toDouble(), in2.toDouble()))
        }
    }

}