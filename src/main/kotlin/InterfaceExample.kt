interface VehicleInterface {
    fun drive()
}

class CarInterface : VehicleInterface {
    override fun drive() {
        println("Автомобиль едет")
    }
}

interface Playable {
    fun play()
}

class Guitar : Playable {
    override fun play() {
        println("Играет гитара")
    }}

fun main() {
    //callInterface1()
    callInterface2()
}

fun callInterface1() {
    val in1 = readLine()!!.toString()
    if (in1 == "drive") {
        val car = CarInterface()
        car.drive()
    }
}

fun callInterface2() {
    val in1 = readLine()!!.toString()
    if (in1 == "play") {
        val guitar = Guitar()
        guitar.play()
    }
}