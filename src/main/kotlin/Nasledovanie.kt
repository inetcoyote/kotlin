// Родительский класс (суперкласс)
open class Animal {
    open fun sound() {
        println("Животное издает звук")
    }
}

// Дочерний класс (подкласс)
class Dog : Animal() {
    override fun sound() {
        println("Гав")
    }
}

class Bird : Animal() {
    override fun sound() {
        println("Чирик")
    }
}

class Cat : Animal() {
    override fun sound() {
        println("Мяу")
    }
}

// Родительский класс (суперкласс)
open class Shape {
    open fun draw() {
        println("Рисуем фигуру")
    }
}

// Дочерний класс (подкласс)
class Circle2 : Shape() {
    override fun draw() {
        println("Рисуем круг")
    }
}

class Square : Shape() {
    override fun draw() {
        println("Рисуем квадрат")
    }
}

class Triangle2 : Shape() {
    override fun draw() {
        println("Рисуем треугольник")
    }
}

// Родительский класс (суперкласс)
open class Vehicle {
    open fun drive() {
        println("Едем на транспортном средстве")
    }
}

// Дочерний класс (подкласс)
class Car2 : Vehicle() {
    override fun drive() {
        println("Едем на машине")
    }
}

class Bicycle : Vehicle() {
    override fun drive() {
        println("Едем на велосипеде")
    }
}

class Boat : Vehicle() {
    override fun drive() {
        println("Плывем на лодке")
    }
}


// Родительский класс (суперкласс)
open class Person (var name: String, var role: String) {

    open fun showInfo() {
        println("Имя: $name")
        println("Роль: $role")
    }
}
class Admin (name: String) : Person (name, "Администратор")  {
    override fun showInfo() {
        println("Имя: $name")
        println("Роль: $role")
    }
}

class Moderator (name: String) : Person (name, "Модератор")  {
    override fun showInfo() {
        println("Имя: $name")
        println("Роль: $role")
    }
}