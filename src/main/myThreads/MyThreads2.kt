import java.util.concurrent.*
import java.util.concurrent.atomic.AtomicInteger
import kotlin.system.measureTimeMillis

fun main() {
    val target = 1_000_000
    val iterations = 1_000_000

    println("Запуск сравнения пулов потоков: увеличение счётчика до $target\n")

    val results = mutableListOf<Pair<String, Long>>()

    // Пул 1: 10 потоков
    val time10 = measureTimeMillis {
        val executor = Executors.newFixedThreadPool(10)
        val counter = AtomicInteger(0)
        val tasks = mutableListOf<Future<*>>()

        repeat(iterations) {
            tasks.add(executor.submit {
                counter.incrementAndGet()
            })
        }

        // Ждём завершения всех задач
        tasks.forEach { it.get() }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)
    }
    results.add("10 потоков" to time10)
    println("10 потоков завершили за: $time10 мс")

    // Пул 2: 20 потоков
    val time20 = measureTimeMillis {
        val executor = Executors.newFixedThreadPool(20)
        val counter = AtomicInteger(0)
        val tasks = mutableListOf<Future<*>>()

        repeat(iterations) {
            tasks.add(executor.submit {
                counter.incrementAndGet()
            })
        }

        tasks.forEach { it.get() }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)
    }
    results.add("20 потоков" to time20)
    println("20 потоков завершили за: $time20 мс")

    // Пул 3: 30 потоков
    val time30 = measureTimeMillis {
        val executor = Executors.newFixedThreadPool(30)
        val counter = AtomicInteger(0)
        val tasks = mutableListOf<Future<*>>()

        repeat(iterations) {
            tasks.add(executor.submit {
                counter.incrementAndGet()
            })
        }

        tasks.forEach { it.get() }
        executor.shutdown()
        executor.awaitTermination(1, TimeUnit.MINUTES)
    }
    results.add("30 потоков" to time30)
    println("30 потоков завершили за: $time30 мс")

    // Определяем победителя
    val winner = results.minByOrNull { it.second }!!
    println("\n🏆 Победил пул: ${winner.first} с результатом ${winner.second} мс")
}