fun main() {
    println("🚀 Основной поток стартовал: ${Thread.currentThread().name}")

    // 1️⃣ Способ: Создание потока через лямбду
    val thread1 = Thread {
        for (i in 1..3) {
            println("   [Поток 1] Выполняется шаг $i в ${Thread.currentThread().name}")
            Thread.sleep(500)
        }
    }
    thread1.name = "Thread-1"
    thread1.priority = Thread.NORM_PRIORITY + 2
    thread1.start()

    // 2️⃣ Способ: Создание с именем через конструктор
    val thread2 = Thread({
        for (i in 1..3) {
            println("   [Поток 2] Выполняется шаг $i в ${Thread.currentThread().name}")
            Thread.sleep(600)
        }
    }, "Thread-2")
    thread2.priority = Thread.NORM_PRIORITY
    thread2.start()

    // 3️⃣ Способ: Наследование от Thread (анонимный объект)
    val thread3 = object : Thread() {
        override fun run() {
            for (i in 1..3) {
                println("   [Поток 3] Выполняется шаг $i в ${Thread.currentThread().name}")
                Thread.sleep(700)
            }
        }
    }
    thread3.name = "Thread-3"
    thread3.priority = Thread.MIN_PRIORITY
    thread3.start()

    // 4️⃣ Способ: Демон-поток
    val daemonThread = Thread {
        while (true) {
            println("   [Демон] Я работаю в фоне... (${Thread.currentThread().name}, демон: ${Thread.currentThread().isDaemon})")
            Thread.sleep(400)
        }
    }
    daemonThread.name = "Daemon-Thread"
    daemonThread.isDaemon = true
    daemonThread.priority = Thread.MAX_PRIORITY
    daemonThread.start()

    // ✅ 5️⃣ Способ: Создание и запуск в одну строку (без отдельной переменной)
    Thread {
        for (i in 1..3) {
            println("   [Поток 4] Выполняется шаг $i в ${Thread.currentThread().name}")
            Thread.sleep(550)
        }
    }.apply {
        name = "Thread-4"
        priority = Thread.NORM_PRIORITY
        start() // ⚠️ start() вызывается явно!
    }

    // 🔍 Вывод информации
    println("\n📋 Информация о потоках:")
    for (t in listOf(thread1, thread2, thread3, daemonThread)) {
        println("   ${t.name}: приоритет=${t.priority}, демон=${t.isDaemon}")
    }

    // ⏳ Ждём завершения всех НЕ-демон потоков
    thread1.join()
    thread2.join()
    thread3.join()

    println("\n🔚 Основной поток завершает работу.")
    println("   Демон-поток будет автоматически остановлен.")
}