class Student {
    var name: String = ""
    var age: Int = 0

    constructor(name: String, age: Int) {
        this.name = name
        this.age = age
    }

    fun printInfo() {
        println("Name: $name, Age: $age")
    }
}