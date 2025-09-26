open class Person2  {
    // Приватное поле без автоматических геттера и сеттера
    private var _name: String = ""

    // Метод для установки имени
    fun setName(newName: String) {
        _name = newName
    }

    // Метод для получения имени (если нужно)
    fun getName(): String {
        return _name
    }

    // Метод для вывода имени
    fun printName() {
        println("Name: $_name")
    }
}

class Student2 : Person2()  {
    private var studentId: Int = 0

    fun setStudentId(newId: Int) {
        studentId = newId
    }

    fun printStudentDetails() {
        println("Name: ${getName()}, Student ID: $studentId")
    }
}

class Teacher {
    internal var subject: String = ""

    fun setSubject(newSubject: String) {
        subject = newSubject
    }

    fun printSubject() {
        println("Subject: $subject")
    }
}