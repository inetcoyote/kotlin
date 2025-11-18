import kotlin.concurrent.thread

class SharedData {
    private var value: Int? = null
    private var isUpdated = false
    private val lock = Any() // Любой объект — будет использоваться как монитор

    // Поток-производитель вызывает этот метод
    fun setValue(newValue: Int) {
        synchronized(lock) {
            value = newValue
            isUpdated = true
            (lock as java.lang.Object).notifyAll() // Явный вызов notifyAll
            println("Записано значение: $newValue")
        }
    }

    // Потоки-наблюдатели вызывают этот метод
    fun getValue(): Int? {
        synchronized(lock) {
            while (!isUpdated) {
                (lock as java.lang.Object).wait() // Явный вызов wait
            }
            isUpdated = false
            return value
        }
    }
}

fun main() {
    val sharedData = SharedData()

    // Поток, который пишет в переменную
    thread(name = "Writer") {
        for (i in 1..5) {
            sharedData.setValue(i)
            Thread.sleep(2000)
        }
        println("Поток-писатель завершил работу.")
    }

    // Три потока, которые следят за переменной
    repeat(3) { observerId ->
        thread(name = "Observer-$observerId") {
            while (true) {
                try {
                    val value = sharedData.getValue()
                    println("Наблюдатель $observerId увидел значение: $value")
                    Thread.sleep(300) // Имитация обработки
                } catch (e: InterruptedException) {
                    println("Наблюдатель $observerId прерван.")
                    return@thread
                } catch (e: Exception) {
                    e.printStackTrace()
                    return@thread
                }
            }
        }
    }

    // Даем программе время на выполнение
    Thread.sleep(12000)
    println("Программа завершена.")
}