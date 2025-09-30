import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException


fun insertData(connection : java.sql.Connection) {
    // Вставка данных
    println("Введите имя")
    val inName = readLine()!!.toString()
    println("Введите возраст")
    val inAge = readLine()!!.toString()
    connection.createStatement().use { stmt ->
        //stmt.executeUpdate("INSERT INTO users (name, age) VALUES ('Alice', 30)")
        //stmt.executeUpdate("INSERT INTO users (name, age) VALUES ('Bob', 25)")
        val sqlstr = "INSERT INTO users (name, age) VALUES ('$inName', $inAge)"
        println(sqlstr)
        stmt.executeUpdate(sqlstr)
        println("Данные добавлены.")
    }
}

fun updateData(connection: Connection) {
    // Обновление данных
    connection.createStatement().use { stmt ->
        //stmt.executeUpdate("UPDATE users SET age = 31 WHERE name = 'Alice'")
        println("Введите id")
        val inId = readLine()!!.toString()
        println("Введите имя")
        val inName = readLine()!!.toString()
        println("Введите возраст")
        val inAge = readLine()!!.toString()
        val sqlstr = "UPDATE users SET age = $inAge , name = '$inName' WHERE id = $inId"
        //println(sqlstr)
        stmt.executeUpdate(sqlstr)
        println("Данные обновлены.")
    }
}

fun readData(connection : java.sql.Connection) {
    // Чтение данных
    connection.createStatement().use { stmt ->
        val rs = stmt.executeQuery("SELECT * FROM users")
        while (rs.next()) {
            val id = rs.getInt("id")
            val name = rs.getString("name")
            val age = rs.getInt("age")
            println("ID: $id, Имя: $name, Возраст: $age")
        }
    }
}

fun deleteData(connection: Connection, count : Int) {
    connection.createStatement().use { stmt ->
        // Удаление строки с id = 1
        val rowsAffected = stmt.executeUpdate("DELETE FROM users WHERE id = $count")
        if (rowsAffected > 0) {
            println("✅ Удалено $rowsAffected строк.")
        } else {
            println("❌ Строка с id = 1 не найдена.")
        }
    }
}

fun createTable(connection : java.sql.Connection) {
    // Создание таблицы
    val createTableSQL = """
                CREATE TABLE IF NOT EXISTS users (
                    id INTEGER PRIMARY KEY AUTOINCREMENT,
                    name TEXT NOT NULL,
                    age INTEGER
                )
            """.trimIndent()

    connection.createStatement().use { stmt ->
        stmt.execute(createTableSQL)
        println("Таблица создана (или уже существует).")
    }
}

fun main() {
    val url = "jdbc:sqlite:test.db"

    // Загрузка драйвера
    try {
        Class.forName("org.sqlite.JDBC")
    } catch (e: ClassNotFoundException) {
        println("Ошибка: JDBC драйвер SQLite не найден.")
        return
    }

    // Подключение к БД
    DriverManager.getConnection(url).use { connection ->
        if (connection != null) {
            println("Подключились к SQLite базе данных!")

            println("Какое действие Вы хотите осуществить (create/read/insert/update/delete) ?")
            val myintype = readLine()!!.toString()
            if (myintype == "create"){
                createTable(connection)
            }
            else if (myintype == "read") {
                readData(connection)
            }
            else if (myintype == "insert") {
                insertData(connection)
            }
            else if (myintype == "update") {
                updateData(connection)
            }
            else if (myintype == "delete") {
                println("Введите номер строки для удаления")
                val count = readLine()!!.toInt()
                deleteData(connection, count)
                println("Листинг данных из БД")
                readData(connection)
            }
            else {
                println("Не найден нужный вид действия")
            }





        }
    }
}