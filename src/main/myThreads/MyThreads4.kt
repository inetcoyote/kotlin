import java.util.concurrent.*
import kotlin.random.Random

// Результат забега одной лошади
data class HorseResult(
    val horseName: String,
    val finishTimeMs: Long
)

// Лошадь — задача, которая "бежит" дистанцию и возвращает результат
class HorseTask(private val name: String, private val distance: Int) : Callable<HorseResult> {
    override fun call(): HorseResult {
        var position = 0
        val startTime = System.currentTimeMillis()

        println("$name стартовала!")

        while (position < distance) {
            // Симуляция бега: каждый шаг — случайная задержка
            val step = 1
            val stepTime = Random.nextLong(50, 200) // от 50 до 200 мс на шаг
            Thread.sleep(stepTime)
            position += step
        }

        val finishTime = System.currentTimeMillis() - startTime
        println("$name финишировала за $finishTime мс")

        return HorseResult(name, finishTime)
    }
}

fun main() {
    val distance = 100
    val horseNames = listOf(
        "Ветер", "Молния", "Торнадо", "Звезда", "Гром",
        "Скорость", "Пума", "Фантом", "Ракета", "Шторм"
    )

    // Создаём пул потоков (отложенный — задачи выполняются по мере готовности)
    val executor = Executors.newFixedThreadPool(4) // Можно использовать newCachedThreadPool()
    val tasks = mutableListOf<Callable<HorseResult>>()

    println("\uD83C\uDFC1 Скачки на лошадях стартуют!")

    // Создаём задачи для каждой лошади
    horseNames.forEach { name ->
        tasks.add(HorseTask(name, distance))
    }

    // Запускаем все задачи и собираем Future
    val futures: List<Future<HorseResult>> = try {
        executor.invokeAll(tasks)
    } finally {
        executor.shutdown()
    }

    // Собираем результаты
    val results: MutableList<HorseResult> = mutableListOf()
    for (future in futures) {
        try {
            results.add(future.get())
        } catch (e: Exception) {
            println("Ошибка при получении результата: ${e.message}")
        }
    }

    // Сортируем по времени (от быстрого к медленному)
    val sortedResults = results.sortedBy { it.finishTimeMs }

    // Выводим таблицу результатов
    println("\n" + "=".repeat(40))
    println("🏁 ФИНИШНЫЙ ПРОТОКОЛ СКАЧЕК")
    println("=".repeat(40))
    println("%-4s %-12s %-10s".format("Место", "Лошадь", "Время (мс)"))
    println("-".repeat(40))

    sortedResults.forEachIndexed { index, result ->
        val place = index + 1
        val medal = when (place) {
            1 -> "🥇"
            2 -> "🥈"
            3 -> "🥉"
            else -> ""
        }
        println("%-4s %-12s %-10s $medal".format("$place.", result.horseName, result.finishTimeMs))
    }

    println("=".repeat(40))
    println("Победители награждены медалями! 🏆")
}