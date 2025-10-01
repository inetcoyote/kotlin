import kotlin.math.PI

class Circle (var radius: Double, var area: Double) {

    fun calculateArea()  {
        area =  Math.PI * radius * radius
    }

}