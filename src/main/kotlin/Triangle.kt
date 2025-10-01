class Triangle (var side1: Double, var side2: Double, var side3: Double)  {

    fun isEquilateral(): String {
        var res = ""
        if (side1 == side2 && side2 == side3) {
            res = "Equilateral"
        }
        else {
            res = "Not Equilateral"
        }
        return res
    }
}
