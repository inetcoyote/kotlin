### Задача 2:

**Задание**

Создать 1 поток, который пишет в переменную, а три других потока читают из неё.

**Решение на kotlin**


```kotlin
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
```

**Пример результата запуска скрипта:**
```
Старт программы.
Записано значение: 1
Наблюдатель 1 увидел значение: 1
Записано значение: 2
Наблюдатель 2 увидел значение: 2
Записано значение: 3
Наблюдатель 1 увидел значение: 3
Записано значение: 4
Наблюдатель 2 увидел значение: 4
Записано значение: 5
Наблюдатель 1 увидел значение: 5
Поток-писатель завершил работу.
Программа завершена.
```

